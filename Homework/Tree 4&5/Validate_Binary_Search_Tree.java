class Solution {
    public boolean isValidBST(TreeNode root) {
        //return isBSThelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
      // question contains duplicate value test cases 
      //             [-2147483648,-2147483648]
      // 
    
        long lb=Long.MIN_VALUE;
        long ub=Long.MAX_VALUE;
        return isBSThelper(root,lb,ub);
    }
    private boolean isBSThelper(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }
        if(root.val<=min || root.val>=max){    //logic fails here (root.val<min || root.val>max)
            return false;
        }

        boolean leftOK=isBSThelper(root.left,min,root.val);
        boolean rightOK=isBSThelper(root.right,root.val,max);

        return leftOK && rightOK;
    }
}
