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
    public List<List<Integer>> levelOrder(TreeNode root) {  
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Queue<TreeNode>pN=new LinkedList<TreeNode>();
         if(root==null){
            return list;
        }
        pN.add(root);
        while(!pN.isEmpty()){
            int len=pN.size();
            List<Integer> level=new ArrayList<Integer>();
            for(int i=0;i<len;i++){
                TreeNode curr=pN.poll();
                level.add(curr.val);
                if(curr.left!=null){
                    pN.add(curr.left);
                }
                if(curr.right!=null){
                    pN.add(curr.right);
                }
            }
            list.add(level);
        }
        return list;
    }
}
