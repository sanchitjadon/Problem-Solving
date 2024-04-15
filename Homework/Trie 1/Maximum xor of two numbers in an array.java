class trie{
    trie[] childs;
    public trie(){
        childs=new trie[2];
    }
}
class Solution {
    public void insert(int num,trie root){
        trie curr=root;
        for(int i=31;i>=0;i--){
            int currBit=(num>>i)&1;
            if(curr.childs[currBit]==null){
                curr.childs[currBit]=new trie();
            }
            curr=curr.childs[currBit];
        }
    }
    public int getmaxXOR(int num,trie root){
        trie curr=root;
        int xor=0;
        for(int i=31;i>=0;i--){
            int currBit=(num>>i)&1;
            int flipBit=1-currBit;
            if(curr.childs[flipBit]!=null){
                xor=xor|(1<<i);
                curr=curr.childs[flipBit];
            }
            else{
                curr=curr.childs[currBit];
            }
        }
        return xor;
    }
    public int findMaximumXOR(int[] nums) {
        trie root=new trie();
        for(int i=0;i<nums.length;i++){
           insert(nums[i],root);
        } 
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            int xor=getmaxXOR(num,root);
            max=Math.max(max,xor);
        }
        return max;
    }
}
