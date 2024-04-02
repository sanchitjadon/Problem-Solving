import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.*;

public class Solution {
    static class Pair{
        TreeNode<Integer> node;
        int level;
        public Pair(TreeNode<Integer> node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public static ArrayList<Integer> leftView(TreeNode<Integer> root){
        ArrayList<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Pair> queue=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair ab=queue.remove();
            int level=ab.level;
            TreeNode<Integer> temp=ab.node;
            if(map.get(level)==null){
                map.put(level,temp.data);
            }
            if(temp.left!=null){
                queue.add(new Pair(temp.left,level+1));
            }
            if(temp.right!=null){
                queue.add(new Pair(temp.right,level+1));
            }
        }
        for(Map.Entry<Integer,Integer> itr : map.entrySet()){
            list.add(itr.getValue());
        }
        return list;
    }
    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.
       ArrayList<Integer> list=leftView(root);
       for(int i=0;i<list.size();i++){
           System.out.print(list.get(i)+" ");
       }
    }
}
