class Solution {
    public void dfs(char[][] grid,boolean[][]visited,int m,int n,int[]Drow,int[]Dcol,int row,int col){
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int nr=row+Drow[i];
            int nc=col+Dcol[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && grid[nr][nc]=='1'){
                dfs(grid,visited,m,n,Drow,Dcol,nr,nc);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][]visited=new boolean[m][n];
        int[]Drow={-1,0,1,0};
        int[]Dcol={0,1,0,-1};
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(grid,visited,m,n,Drow,Dcol,i,j);
                }
            }
        }
        return count;
    }
}
