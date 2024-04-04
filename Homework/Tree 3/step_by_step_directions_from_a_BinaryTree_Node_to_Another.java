class Solution {
    public TreeNode findLCA(TreeNode root,int startValue,int destValue){
        if(root==null || root.val==startValue || root.val==destValue){
            return root;
        }
        TreeNode left=findLCA(root.left,startValue,destValue);
        TreeNode right=findLCA(root.right,startValue,destValue);
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
    public boolean findPath(TreeNode root,int start,StringBuilder str){
        if(root==null){
            return false;
        }
        if(root.val==start){ 
            return true;
        }
        str.append("L");
        boolean result=findPath(root.left,start,str);
        if(result){
            return true;
        }
        str.deleteCharAt(str.length()-1);
        str.append("R");
        result=findPath(root.right,start,str);
        if(result){
            return true;
        }
        str.deleteCharAt(str.length()-1);
        return false;
    } 
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA=findLCA(root,startValue,destValue);
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        findPath(LCA,startValue,str1);
        findPath(LCA,destValue,str2);
        for(int i=0;i<str1.length();i++){
            str1.setCharAt(i,'U');
        }
        return str1.append(str2).toString();
    }
}
