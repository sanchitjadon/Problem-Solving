class Solution{
    public TreeNode bstFromPreorder(int[] preorder){
        int[] pre_index = {0};
        return build_tree(preorder , pre_index , 1001);
    }
    
    private TreeNode build_tree(int[] preorder , int[] pre_index , int bound){
      if(pre_index[0] >= preorder.length || preorder[pre_index[0]] >= bound)
          return null;
      
      TreeNode root = new TreeNode(preorder[pre_index[0]]);
      pre_index[0]++;
      
      root.left = build_tree(preorder , pre_index , root.val);
      root.right = build_tree(preorder , pre_index , bound);
      
      return root;
    }
}
