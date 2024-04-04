class Solution {
    public void check(TreeNode root,int targetSum,int currSum,List<Integer> temp,List<List<Integer>>list){
        if(root==null){
            return;
        }
        currSum+=root.val;
        temp.add(root.val);
        if(root.left==null && root.right==null ){
            if(currSum==targetSum){
                list.add(new ArrayList<>(temp));
                // return;
            }    
        }
        check(root.left,targetSum,currSum,temp,list);
        check(root.right,targetSum,currSum,temp,list);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        check(root,targetSum,0,temp,list);
        return list;
    }
}

// public List storePaths(TreeNode root,int targetSum,List<List<Integer>> list,List<Integer> temp,int currSum){
    //     if(root==null){
    //         return temp;
    //     }
    //     temp.add(root.val);
    //     currSum+=root.val;
    //     if(root.left==null && root.right==null && currSum==targetSum){
    //             list.add(temp);
    //     }
    //     storePaths(root.left,targetSum,list,temp,currSum);
    //     storePaths(root.right,targetSum,list,temp,currSum);
    //     return temp; 
    // }
    // public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    //     List<List<Integer>> list=new ArrayList<>();
    //     List<Integer> temp=new ArrayList<>();
    //     storePaths(root,targetSum,list,temp,0);
    //     return list;
    // }
