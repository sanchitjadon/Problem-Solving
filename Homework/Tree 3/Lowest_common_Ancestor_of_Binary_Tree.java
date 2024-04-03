// optimized Solution of dfs traversal
//time complexity=O(n)
//space complexity=O(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode leftAnsNode=lowestCommonAncestor(root.left,p,q);
        TreeNode rightAnsNode=lowestCommonAncestor(root.right,p,q);

        if(leftAnsNode==null){
            return rightAnsNode;
        }
        else if(rightAnsNode==null){
            return leftAnsNode;
        }
        else{
            return root;
        }
    }
}


//Brute Force Solution
//time complexity=O(n)+O( min sized array)
//space complexity=O(n)+O(n)+O(n)

class Solution {
    public TreeNode findLCA(List<TreeNode> list1,List<TreeNode> list2){
        int n=Math.min(list1.size(),list2.size());
        for(int i=1;i<n;i++){
            if(list1.get(i)!=list2.get(i)){
                return list1.get(i-1);
            }
        }
        return list1.get(n-1);
    }
    public boolean findPath(TreeNode root,int node,List<TreeNode> list){
        if(root==null){
            return false;
        }
        list.add(root);
        if(root.val==node){
            return true;
        }
        if(findPath(root.left,node,list) || findPath(root.right,node,list)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathRootToP=new LinkedList<>();
        List<TreeNode> pathRootToQ=new LinkedList<>();
        findPath(root,p.val,pathRootToP);
        findPath(root,q.val,pathRootToQ);
        TreeNode LCA=findLCA(pathRootToP,pathRootToQ);
        return LCA;
    }
}
