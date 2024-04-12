class trie{
    int count;
    trie[] childs;
    public trie(){
        childs=new trie[26];
        count=0;
    }
}
class Solution {
    public void insert(String word,trie root){
        trie curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.childs[idx]==null){
                curr.childs[idx]=new trie();
            }
            curr=curr.childs[idx];
            curr.count++;
        }
    }
    public int countOfPreffixWord(trie root,String prefix){
        trie curr=root;
        int cnt=0;
        for(int i=0;i<prefix.length();i++){
            int ind=prefix.charAt(i)-'a';
            if(curr.childs[ind]==null){
                return 0;
            }
            curr=curr.childs[ind];
            cnt+=curr.count;
        }
        return cnt;
    }
    public int[] sumPrefixScores(String[] words) {
        int [] arr=new int[words.length];
        trie root=new trie();
        for(String keys:words){
            insert(keys,root);
        }
        for(int i=0;i<words.length;i++){
            int sum=countOfPreffixWord(root,words[i]);
            arr[i]=sum;
        }
        return arr;
    }
}
