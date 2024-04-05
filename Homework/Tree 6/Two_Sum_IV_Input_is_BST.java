/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorder(TreeNode root,int k,List<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,k,list);
        list.add(root.val);
        inorder(root.right,k,list);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        inorder(root,k,list);
        int low=0;
        int high=list.size()-1;
        while(low<high){
            int sum=list.get(low)+list.get(high);
            if(sum==k){
                return true;
            }
            else if(sum>k){
                high--;
            }
            else{
                low++;
            }
        }
        return false;
    }
}
