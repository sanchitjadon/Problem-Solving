public class Solution {
    public static int heightOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=1;
        int left=ans+heightOfBinaryTree(root.left);
        int right=ans+heightOfBinaryTree(root.right);
        return Math.max(left,right);
    }
}
