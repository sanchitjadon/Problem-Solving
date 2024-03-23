class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        boolean a;
        boolean b;
        if(p.val==q.val){
            a=isSameTree(p.left,q.left);
            b=isSameTree(p.right,q.right);
        }
        else{
            return false;
        }
        return a&&b;
    }
}
