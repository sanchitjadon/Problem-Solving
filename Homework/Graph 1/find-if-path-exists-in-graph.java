class Solution {
    public boolean validPathHelper(List<List<Integer>> edges,int start,int end,boolean[] visited){
        if(start==end){
            return true;
        }
        visited[start]=true;
        for(int i:edges.get(start)){
            if(!visited[i]){
                if(validPathHelper(edges,i,end,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        //int[][]adj=new int[n][n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        boolean visited[]=new boolean[n];
        for(int []edge: edges){
            int sv=edge[0];
            int ev=edge[1];
            // adj[sv][ev]=1;
            // adj[ev][sv]=1;
            adj.get(sv).add(ev);
            adj.get(ev).add(sv);
        }
        return validPathHelper(adj,source,destination,visited);
    }
}
