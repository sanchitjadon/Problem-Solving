class Solution {
    public boolean dfs(int v,List<List<Integer>>adj,boolean[]vis,boolean[]pathVis,int src){
        vis[src]=true;
        pathVis[src]=true;
        for(int x:adj.get(src)){
            if(!vis[x]){
                if(dfs(v,adj,vis,pathVis,x)){
                    return true;
                }
            }
            else if(pathVis[x]){
                return true;
            }
        }
        pathVis[src]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int v=numCourses;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[]vis=new boolean[v];
        boolean[]pathVis=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                if(dfs(v,adj,vis,pathVis,i)){
                    return false;
                }
            }
        }
        return true;
    }
}
