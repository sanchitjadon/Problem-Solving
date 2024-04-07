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

class NodeInfo{
    int max;
    int min;
    int sum=0;
    public NodeInfo(int min,int max,int sum)
    {
        this.max=max;
        this.min=min;
        this.sum=sum;
    }
}
class Solution {
    int ans=0;
    public NodeInfo ValidBST(TreeNode root) {
        if(root==null) return null;
        NodeInfo left= ValidBST(root.left);
        NodeInfo right= ValidBST(root.right);
        if(left==null && root.left!=null)
        {
            return null;
        }
        if(right==null && root.right!=null)
        {
            return null;
        }
        boolean flag=true;
        if(left!=null &&  left.max>=root.val) {
            flag=false;
        }
        if(flag && right!=null && right.min<=root.val){
            flag=false;
        }
        if(flag==false)
        {
            return null;
        }
        int leftSum=(left!=null)?left.sum:0;
        int rightSum=(right!=null)?right.sum:0;
        int minValue=(left==null)?root.val:left.min;
        int maxValue=(right==null)?root.val:right.max;
        ans=Math.max(ans,leftSum+rightSum+root.val);
        return new NodeInfo(minValue,maxValue,leftSum+rightSum+root.val);
    }

    public int maxSumBST(TreeNode root) {
        NodeInfo node= ValidBST(root);
        return ans;
        
    }
}
