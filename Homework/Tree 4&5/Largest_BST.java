// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }
class nodevalues{
        int maxvalue;
        int minvalue;
        int size;
        public nodevalues(int maxvalue,int minvalue,int size){
            this.maxvalue=maxvalue;
            this.minvalue=minvalue;
            this.size=size;
        }
}

class Solution{
    static nodevalues largestBstHelper(Node root){
        if(root==null){
            return new nodevalues(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        nodevalues left=largestBstHelper(root.left);
        nodevalues right=largestBstHelper(root.right);
        if(left.maxvalue<root.data && root.data<right.minvalue){
            return new nodevalues(Math.min(root.data, left.minvalue),Math.max(root.data, right.maxvalue), left.size + right.size + 1);
        }
        return new nodevalues(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size, right.size));
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return largestBstHelper(root).size;
        
        
    }
    
}
