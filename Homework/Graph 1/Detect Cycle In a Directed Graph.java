class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int n,boolean[]visited,boolean[]pathVisited,int start){
        visited[start]=true;
        pathVisited[start]=true;
        for(int i:adj.get(start)){
            if(!visited[i]){
                if(dfs(adj,n,visited,pathVisited,i)){
                    return true;
                }
            }
            else if(pathVisited[i]){
                return true;
            }
        }
        pathVisited[start]=false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        boolean []visited=new boolean[n];
        boolean []pathVisited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                boolean ans=dfs(adj,n,visited,pathVisited,i);
                if(ans){
                    return true;
                }
            }
        }
        return false;
    }
}
