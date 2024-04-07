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
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        count=0;
        traverseAndCall(root,targetSum);
        return count;
    }
    public void traverseAndCall(TreeNode root,long targetSum){
        if(root==null)return;
        checkSum(root,targetSum);
        traverseAndCall(root.left,targetSum);
        traverseAndCall(root.right,targetSum);
    }
    public void checkSum(TreeNode root, long targetSum){
        if(root==null)return;
        // System.out.println(targetSum);
        if(targetSum-root.val==0){
            count++;
            
        }
        checkSum(root.left,targetSum-root.val);
        checkSum(root.right,targetSum-root.val);
    }
}
