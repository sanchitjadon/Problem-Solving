//BRUTE FORCE 
//time complexity=O(n)+O(log2(n))
//space complexity=O(n)+O(n)
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
//optimized solution
// time complexity=O(log2(n))
// space complexity=O(1)
class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        Node temp=root;
        int i=Integer.MAX_VALUE;
        while(temp!=null){
            if(temp.data==key){
                return temp.data;
            }
            else if(temp.data<key){
                temp=temp.right;
            }
            else{
                i=Math.min(i,temp.data);
                temp=temp.left;
            }
        }
        if(i==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return i;
        }
    }
}
