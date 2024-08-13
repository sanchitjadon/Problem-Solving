 ----------[ RECURSION ]------------
class Solution {
    private int totalPaths(int row, int column) {
        if(row == 0 && column == 0) {
            return 1;
        }
        if(row < 0 || column < 0){
            return 0;
        }
        int up = totalPaths(row - 1, column);
        int left = totalPaths(row, column - 1);
        return up + left; 
    }
    public int uniquePaths(int m, int n) {
        return totalPaths(m-1, n-1);
    }
}


--------------[ TOP DOWN + MEMOIZATION ]---------------

class Solution {
    private int totalPaths(int row, int column, int[][] dp) {
        if(row == 0 && column == 0) {
            return 1;
        }
        if(row < 0 || column < 0){
            return 0;
        }
        if(dp[row][column] != -1){
            return dp[row][column];
        }
        int up = totalPaths(row - 1, column, dp);
        int left = totalPaths(row, column - 1, dp);
        return dp[row][column] = up + left; 
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return totalPaths(m-1, n-1, dp);
    }
}

------------[ BOTTOM UP ]-------------

class Solution {
    public int uniquePaths(int m , int n) {
        int[][] dp = new int[m][n];
        for(int col = 0; col < n; col++){
            dp[0][col] = 1;
        }
        for(int row = 0; row < m; row++){
            dp[row][0] = 1;
        }

        for(int row = 1; row < m; row++) {
            for(int column = 1; column < n; column++) {
                dp[row][column] = dp[row - 1][column] + dp[row][column - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}


               BOTTOM UP OPTIMIZED     
--------------------------------------------------
class Solution {
    public int uniquePaths(int m , int n) {
        int[] previous = new int[n];
        previous[0] = 1;
        for(int row = 0; row < m; row++) {
            int[] current = new int[n];
            current[0] = 1;
            for(int column = 1; column < n; column++) {
                current[column] = previous[column] + current[column - 1];
            }
            previous = current;
        }
        return previous[n-1];
    }
}
