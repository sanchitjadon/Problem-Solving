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

//time complexity=O(n)
//space complexity=O(list)+O(n)
class Solution {
    public void sumofnodes(TreeNode root,int low,int high,List<Integer> list){
        if(root==null){
            return; 
        }
        if(root.val>=low && root.val<=high){
            list.add(root.val);
        }
        sumofnodes(root.left,low,high,list);
        sumofnodes(root.right,low,high,list);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> list=new ArrayList<>();
        sumofnodes(root,low,high,list);
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }
}
