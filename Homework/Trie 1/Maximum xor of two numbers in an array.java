class trie{
    trie[] childs;
    public trie(){
        childs=new trie[2];
    }
}
class Solution {
    public void insert(String binary,trie root){
        trie curr=root;
        for(int i=0;i<binary.length();i++){
            int index=binary.charAt(i)-'0';
            if(curr.childs[index]==null){
                curr.childs[index]=new trie();
            }
            curr=curr.childs[index];
        }
    }
    public String getmaxXOR(String word,trie root){
        trie curr=root;
        String str="";
        for(int i=0;i<word.length();i++){
            char idx=word.charAt(i);
            if(idx=='0' && curr.childs['1'-'0']!=null){
                str+="1";
                curr=curr.childs['1'-'0'];
            }
            else if(idx=='1' && curr.childs['0'-'0']!=null){
                str+="0";
                curr=curr.childs['0'-'0'];
            }
            else{
                str+=String.valueOf(idx);
                curr=curr.childs[idx-'0'];
            }
        }
        return str;
    }
    public int xor(String binary){
        int dec_value=0;
        int base=1;
        int len = binary.length();
        for (int i = len - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }
        return dec_value;
    }
    public int findMaximumXOR(int[] nums) {
        String[]binary=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            String s="";
            for(int j=31;j>=0;j--){
                int k=nums[i]>>j;
                if((k&1)>0){
                    s+="1";
                }
                else{
                    s+="0";
                }
            }
            binary[i]=s;
        }
        trie root=new trie();
        for(String key:binary){
            insert(key,root);
        }
        int max=Integer.MIN_VALUE;
        for(String word:binary){
            String str=getmaxXOR(word,root);
            int a=xor(str);
            int b=xor(word);
            int ans=a^b;
            if(ans>max){
                max=ans;
            }
        }
        return max;
    }
}
