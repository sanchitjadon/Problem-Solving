class Solution {
    public int orangesRotting(int[][] grid) {
        int []Drow={-1,0,1,0};
        int []Dcol={0,1,0,-1};
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int count=0;
        while(!q.isEmpty() && fresh!=0){
            int size=q.size();
            count++;
            for(int i=0;i<size;i++){
                int []rotten=q.poll();
                int row=rotten[0];
                int col=rotten[1];
                for(int j=0;j<4;j++){
                    int nr=row+Drow[j];
                    int nc=col+Dcol[j];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
        }
        if(fresh!=0){
            return -1;
        }
        return count;
    }
}
