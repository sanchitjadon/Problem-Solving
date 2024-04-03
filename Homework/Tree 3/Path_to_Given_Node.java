/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public boolean checkNode(TreeNode A,int B,ArrayList<Integer> list){
        if(A==null){
            return false;
        }
        list.add(A.val);
        if(A.val==B){
            return true;
        }
        if(checkNode(A.left,B,list)||checkNode(A.right,B,list)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> list=new ArrayList<>();
        checkNode(A,B,list);
        int []arr=new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}
//time complexity=O(n)+O(arr.length)
//space complexity=O(n)+O(n)+O(n)

// i'll try to optimize it in revision
