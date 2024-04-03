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
    public int findLCA(List<Integer> list1,List<Integer> list2){
        for(int i=1;i<Math.min(list1.size(),list2.size());i++){
            if(list1.get(i)!=list2.get(i)){
                return list1.get(i-1);
            }
        }
        return list1.get(Math.min(list1.size(),list2.size())-1);
    }
    public boolean findPath(TreeNode root,int node,List<Integer> list){
        if(root==null){
            return false;
        }
        list.add(root.val);
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
        List<Integer> pathRootToP=new ArrayList<>();
        List<Integer> pathRootToQ=new ArrayList<>();
        findPath(root,p.val,pathRootToP);
        findPath(root,q.val,pathRootToQ);
        int LCA=findLCA(pathRootToP,pathRootToQ);
        TreeNode node=new TreeNode(LCA);
        return node;
    }
}
