class TrieNode {
    char data;
    boolean isTerminal;
    TrieNode[] children;

    TrieNode(char data) {
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
    }
}
class Solution{
    static void insertWord(TrieNode root, String str) {
        if (str.length() == 0) {
            root.isTerminal = true;
            return;
        }
        char ch = str.charAt(0);
        int index = ch - 'a';

        TrieNode child;

        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            child = new TrieNode(ch);
            root.children[index] = child;
        }

        insertWord(child, str.substring(1));
    }
    static void printSuggestion(TrieNode curr, ArrayList<String> temp, String inputHelper, StringBuilder dummy) {
        if (curr.isTerminal) {
            temp.add(inputHelper + dummy.toString());
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = ch - 'a';
            TrieNode next = curr.children[index];

            if (next != null) {
                dummy.append(ch);
                printSuggestion(next, temp, inputHelper, dummy);
                dummy.deleteCharAt(dummy.length() - 1);
            }
        }
    }
    static ArrayList<ArrayList<String>> getSuggestion(TrieNode root, String query) {
        String inputHelper = "";
        TrieNode prev = root;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        for (int i = 0; i < query.length(); i++) {
            char lastCh = query.charAt(i);
            inputHelper += lastCh;

            int index = lastCh - 'a';
            TrieNode curr = prev.children[index];

            if (curr != null) {
                ArrayList<String> temp = new ArrayList<>();
                StringBuilder dummy = new StringBuilder();
                printSuggestion(curr, temp, inputHelper, dummy);
                ans.add(temp);
                prev = curr;
            } else {
                break;
            }
        }

        int remaining = query.length() - ans.size();
        for (int i = 0; i < remaining; i++) {
            ans.add(new ArrayList<>());
        }

        return ans;
    }
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        TrieNode root = new TrieNode('#');
        for (int i = 0; i < n; i++) {
            insertWord(root, contact[i]);
        }

        return getSuggestion(root, s);
    }
}
