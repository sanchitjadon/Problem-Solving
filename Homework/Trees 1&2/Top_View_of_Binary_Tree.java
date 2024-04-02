class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class pairs{
        Node node;
        int line;
        public pairs(Node node,int line){
            this.node=node;
            this.line=line;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<pairs> queue=new LinkedList<pairs>();
        Map<Integer,Integer> map=new TreeMap<>();
        queue.add(new pairs(root,0));
        while(!queue.isEmpty()){
            pairs ab=queue.remove();
            int verticalLine=ab.line;
            Node temp=ab.node;
            if(map.get(verticalLine)==null){
                map.put(verticalLine,temp.data);
            }
            if(temp.left!=null){
                queue.add(new pairs(temp.left,verticalLine-1));
            }
            if(temp.right!=null){
                queue.add(new pairs(temp.right,verticalLine+1));
            }
        }
        for(Map.Entry<Integer,Integer> itr: map.entrySet()){
            list.add(itr.getValue());
        }
        return list;
    }
}

//time complexity=O(n)
//space complexity=O(n)+O(n) 
