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
    class coords{
        TreeNode root;
        int x;
        int y;
        public coords(TreeNode root,int x,int y){
            this.root=root;
            this.x=x;
            this.y=y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Map<Integer,PriorityQueue<coords>>map=new HashMap<>();
        Queue<coords> queue=new LinkedList<>();
        queue.offer(new coords(root,0,0));
        Comparator<coords> comparator=(a,b) ->{
            if(a.y==b.y){
                return a.root.val-b.root.val;
            }
            else{
                return a.y-b.y;
            }
        };
        int minIdx=0;
        int maxIdx=0;
        while(!queue.isEmpty()){
            coords co=queue.poll();
            root=co.root;
            map.putIfAbsent(co.x,new PriorityQueue<>(comparator));
            map.get(co.x).add(co);
            minIdx=Math.min(minIdx,co.x);
            maxIdx=Math.max(maxIdx,co.x);
            if(root.left !=null){
                queue.offer(new coords(root.left, co.x-1,co.y+1));
            }
            if(root.right !=null){
                queue.offer(new coords(root.right, co.x+1, co.y+1));
            }
        }
        for(int i=minIdx; i<=maxIdx;i++){
            PriorityQueue<coords> pq=map.get(i);
            List<Integer> list = new ArrayList<>();
            while(!pq.isEmpty()){
                list.add(pq.poll().root.val);
            }
            res.add(list);
        }
        return res;
    }
}
