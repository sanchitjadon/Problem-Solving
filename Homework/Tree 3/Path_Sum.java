class Solution {
    public static boolean check(TreeNode root,int targetSum,int currSum){
        if(root==null){
            return false;
        }
        currSum+=root.val;
        if(root.left==null && root.right==null){
            return currSum==targetSum;
        }
        return check(root.left,targetSum,currSum) || check(root.right,targetSum,currSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean ans=check(root,targetSum,0);
        return ans;
    }
}
