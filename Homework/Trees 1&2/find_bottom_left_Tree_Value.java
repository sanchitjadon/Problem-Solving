import java.util.*;
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> pending=new LinkedList <>();
        pending.add(root);
        while(!pending.isEmpty()){
                root=pending.poll();
                if(root.right!=null){
                    pending.add(root.right);
                }
                if(root.left!=null){
                    pending.add(root.left);
                }
        }
        return root.val;
    }
}
