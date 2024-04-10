class Solution {
    class Trie{
        Trie child[];
        boolean end;
        public Trie(){
            child=new Trie[26];
            for(int i=0;i<child.length;i++){
                child[i]=null;
            }
            end=false;
        }
    }
    
    public void insert(String word,Trie root){
        Trie curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Trie();
            }
            if(i==word.length()-1){
                curr.child[idx].end=true;
            }
            curr=curr.child[idx];
        }
    }
    public String replace(String word,Trie root,String ans){
        Trie curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                return word;
            }
            else{
                if(curr.child[idx].end){
                    return word.substring(0,i+1);
                }
                curr=curr.child[idx];
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root =new Trie();
        for(int i=0;i<dictionary.size();i++){
            insert(dictionary.get(i),root);
        }
        String keys[]=sentence.split(" ");
        String ans="";
        for(int i=0;i<keys.length;i++){
            ans=ans+" "+replace(keys[i],root,ans);
        }
        return ans.substring(1);
    }
}
