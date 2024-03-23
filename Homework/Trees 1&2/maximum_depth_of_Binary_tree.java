class Solution {
    //public static int a=1;
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=1;
        int leftans=ans+maxDepth(root.left);
        int rightans=ans+maxDepth(root.right);
        return Math.max(leftans,rightans);
    }
}
