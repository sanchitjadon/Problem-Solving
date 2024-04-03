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
class Solution {
    public static void chechleaf(TreeNode root,List<String>list,String path){
        if(root==null){
            return ;
        }
        path=path+String.valueOf(root.val)+"->";
        if(root.left==null && root.right==null){
            list.add(path.substring(0,path.length()-2));
            return ;
        }
        chechleaf(root.left,list,path);
        chechleaf(root.right,list,path);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>list=new ArrayList<>();
        String str="";
        chechleaf(root,list,str);
        return list;
    }
}
