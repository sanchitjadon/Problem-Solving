class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int m=grid.length;
        int n=grid[0].length;
        int [][]ans=new int[m][n];
        boolean[][]vis=new boolean[m][n];
        Queue<int[]>q=new LinkedList<>();
        int []Drow={-1,0,1,0};
        int []Dcol={0,1,0,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int []triplet=q.poll();
                int x=triplet[0];
                int y=triplet[1];
                int d=triplet[2];
                ans[x][y]=d;
                for(int j=0;j<4;j++){
                    int nr=x+Drow[j];
                    int nc=y+Dcol[j];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc] && grid[nr][nc]==0){
                        q.add(new int[]{nr,nc,d+1});
                        vis[nr][nc]=true;
                    }
                }
            }
        }
        return ans;
    }
    
}
