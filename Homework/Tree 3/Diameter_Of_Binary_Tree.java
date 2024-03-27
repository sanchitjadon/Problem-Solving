class Solution {
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int ans=1;
        int left=ans+height(root.left);
        int right=ans+height(root.right);
        return Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int a=height(root.left)+height(root.right);
        int b=diameterOfBinaryTree(root.left);
        int c=diameterOfBinaryTree(root.right);
        int d=Math.max(a,Math.max(b,c));
        return d;
    }
}
