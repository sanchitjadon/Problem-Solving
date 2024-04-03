class GfG {
    Node LCA(Node root,int a,int b){
        if(root==null || root.data==a || root.data==b){
            return root;
        }
        Node leftAns=LCA(root.left,a,b);
        Node rightAns=LCA(root.right,a,b);
        if(leftAns==null){
            return rightAns;
        }
        else if(rightAns==null){
            return leftAns;
        }
        else{
            return root;
        }
    }
    boolean checkpath(Node root,int p,ArrayList<Integer> list){
        if(root==null){
            return false;
        }
        list.add(root.data);
        if(root.data==p){
            return true;
        }
        if(checkpath(root.left,p,list) || checkpath(root.right,p,list)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
    int distance(Node root,int dist,int p){
        ArrayList<Integer> list=new ArrayList<>();
        checkpath(root,p,list);
        dist=list.size()-1;
        return dist;
        
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        Node node=LCA(root,a,b);
        int x=distance(node,0,a);
        int y=distance(node,0,b);
        return x+y;
    }
}
