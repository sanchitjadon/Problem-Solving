class Solution {
    public void dfs(char[][]board,boolean[][]visited,int m,int n,int[]rowD,int[]colD,int row,int col){
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int mrow=row+rowD[i];
            int ncol=col+colD[i];
            if(mrow>=0 && mrow<m && ncol>=0 && ncol<n && !visited[mrow][ncol] && board[mrow][ncol]=='O'){
                dfs(board,visited,m,n,rowD,colD,mrow,ncol);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][]visited=new boolean[m][n];
        int[]rowD={-1,0,1,0};
        int[]colD={0,1,0,-1};
        for(int j=0;j<n;j++){
            if(board[0][j]=='O' && !visited[0][j]){
                dfs(board,visited,m,n,rowD,colD,0,j);
            }
            if(board[m-1][j]=='O' && !visited[m-1][j]){
                dfs(board,visited,m,n,rowD,colD,m-1,j);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && !visited[i][0]){
                dfs(board,visited,m,n,rowD,colD,i,0);
            }
            if(board[i][n-1]=='O' && !visited[i][n-1]){
                dfs(board,visited,m,n,rowD,colD,i,n-1);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}
