class Solution {
    public void find(int[][]edges,int start,boolean[]visited,int n){
        visited[start]=true;
        for(int i=0;i<n;i++){
            if(edges[start][i]==1 && !visited[i]){
                find(edges,i,visited,n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[]visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                find(isConnected,i,visited,n);
            }
        }
        return count;
    }
}
