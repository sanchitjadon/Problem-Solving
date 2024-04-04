class Tree {
    void findInorder(Node root,List<Integer> list){
        if(root==null){
            return;
        }
        findInorder(root.left,list);
        list.add(root.data);
        findInorder(root.right,list);
    }
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
       List<Integer> list=new ArrayList<>();
       findInorder(root,list);
       int low=0;
       int high=list.size()-1;
       if(key>list.get(high) || key<list.get(low)){
           return -1;
       }
       
       while(low<=high){
           int mid=low+(high-low)/2;
           if(list.get(mid)==key){
               return list.get(mid);
           }
           else if(list.get(mid)>key){
               high=mid-1;
           }
           else{
               low=mid+1;
           }
       }
       return list.get(low);
    }
}
