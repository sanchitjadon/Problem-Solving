/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode LCA(TreeNode root,TreeNode p,TreeNode q){
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left=LCA(root.left,p,q);
        TreeNode right=LCA(root.right,p,q);
        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{
            return root;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root,p,q);
    }
}
