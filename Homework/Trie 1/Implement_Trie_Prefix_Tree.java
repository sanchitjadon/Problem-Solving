class Trie {
    static class TrieNode{
        TrieNode[] childs;
        boolean isEnd;

        public TrieNode() {
            childs=new TrieNode[26];
            for(int i=0;i<childs.length;i++){
                childs[i]=null;
            }
            isEnd=false;
        }
        
    }
    TrieNode root=new TrieNode();
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.childs[index]==null){
                curr.childs[index]=new TrieNode();
            }
            if(i==word.length()-1){
                curr.childs[index].isEnd=true;
            }
            curr=curr.childs[index];
        }
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.childs[index]==null){
                return false;
            }
            if(i==word.length()-1 && !curr.childs[index].isEnd){
                return false;
            }
            curr=curr.childs[index];
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            int index=prefix.charAt(i)-'a';
            if(curr.childs[index]==null){
                return false;
            }
            curr=curr.childs[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
