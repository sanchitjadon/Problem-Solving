class Solution {
    public void dfs(char[][]grid,int m,int start,boolean []visited){
        visited[start]=true;
        for(int i=0;i<grid[0].length;i++){
            if(grid[start][i]==1 && !visited[i]){
                dfs(grid,m,i,visited);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[]visited=new boolean[m];
        int count=0;
        for(int i=0;i<m;i++){
            if(!visited[i]){
                dfs(grid,m,i,visited);
                count++;
            }
        }
        return count;
    }
}
