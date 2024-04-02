class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    static class Pairs{
        Node node;
        int line;
        public Pairs(Node node,int line){
            this.node=node;
            this.line=line;
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Pairs>queue=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        queue.add(new Pairs(root,0));
        while(!queue.isEmpty()){
            Pairs ab=queue.remove();
            int line=ab.line;
            Node temp=ab.node;
           // yaha par change hai ki har vertical line ka last element hamesha bottom se dikhega 
           // isi liye yha map me line(key) ki value last tak update karte rahenge
            map.put(line,temp.data);
            if(temp.left!=null){
                queue.add(new Pairs(temp.left,line-1));
            }
            if(temp.right!=null){
                queue.add(new Pairs(temp.right,line+1));
            }
        }
        for(Map.Entry<Integer,Integer> itr: map.entrySet()){
            list.add(itr.getValue());
        }
        return list;
    }
}
