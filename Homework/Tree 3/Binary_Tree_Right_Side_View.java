// level order traversal 
// har level ka last node hame right view me dhikhega isliye hum map me value update karte rahenge for every level 
class Solution {
    class Pair{
        TreeNode node;
        int level;
        public Pair(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Pair>queue=new LinkedList<>();
        Map<Integer,Integer>map=new TreeMap<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair ab=queue.poll();
            int level=ab.level;
            TreeNode temp=ab.node;
            map.put(level,temp.val);
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
}
