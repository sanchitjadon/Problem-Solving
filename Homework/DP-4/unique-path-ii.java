              [TOP DOWN + MEMOIZATION]
------------------------------------------------------
class Solution {
    private int uniquePaths(int[][] obstacleGrid, int row, int column, int[][] dp){
        if(row == 0 && column == 0) {
            return 1;
        }
        if(row < 0 || column < 0 || obstacleGrid[row][column] == 1) {
            return 0;
        }
        if(dp[row][column] != -1) {
            return dp[row][column];
        }
        int up = uniquePaths(obstacleGrid, row - 1, column, dp);
        int left = uniquePaths(obstacleGrid, row, column - 1, dp);
        return dp[row][column] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        return uniquePaths(obstacleGrid, m - 1, n - 1, dp);
    }
}


            [BOTTOM UP]
-------------------------------------------------
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        
        dp[0][0] = 1;
        for(int column = 1; column < n; column++) {
            if(obstacleGrid[0][column] == 1) {
                break;
            }
            dp[0][column] = 1;
        }
        for(int row = 1; row < m; row++) {
            if(obstacleGrid[row][0] == 1) {
                break;
            }
            dp[row][0] = 1;
        }

        for(int row = 1; row < m; row++) {
            for(int column = 1; column < n; column++) {
                if(obstacleGrid[row][column] == 1) {
                    continue;
                }
                dp[row][column] = dp[row - 1][column] + dp[row][column - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

              BOTTOM UP OPTIMIZED
--------------------------------------------------

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] previous = new int[n];
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        previous[0] = 1;
        for(int row = 0; row < m; row++) {
            int[] current = new int[n];
            current[0] = (obstacleGrid[row][0] == 1 || previous[0] == 0) ? 0 : 1;
            for(int column = 1; column < n; column++) {
                if(obstacleGrid[row][column] == 1) {
                    current[column] = 0;
                    continue;
                }
                current[column] = previous[column] + current[column - 1];
            }
            previous = current;
        }
        return previous[n - 1];
    }
}
