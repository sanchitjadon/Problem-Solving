             TOP DOWN + MEMOIZATION
-------------------------------------------------------------
class Solution {
    private int minPathSumHelper(int[][] grid, int row, int column, int[][] dp) {
        if(row == 0 && column == 0) {
            return grid[0][0];
        }
        if(row < 0 || column < 0) {
            return Integer.MAX_VALUE % 1000000007;
        }
        if(dp[row][column] != -1) {
            return dp[row][column];
        }
        int up = grid[row][column] + minPathSumHelper(grid, row - 1, column, dp);
        int left = grid[row][column] + minPathSumHelper(grid, row, column - 1, dp);
        return dp[row][column] = Math.min(up, left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        return minPathSumHelper(grid, m - 1, n - 1, dp);
    }
}


           BOTTOM UP
-----------------------------------------------------
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int row = 0; row < m; row++) {
            for(int column = 0; column < n; column++) {
                if(row == 0 && column != 0) {
                    dp[row][column] = grid[row][column] + dp[row][column - 1];
                    continue;
                }
                else if(row != 0 && column == 0) {
                    dp[row][column] = grid[row][column] + dp[row - 1][column];
                    continue;
                }
                if(row > 0 && column > 0) {
                    dp[row][column] = grid[row][column] + Math.min(dp[row - 1][column], dp[row][column - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

              BOTTOM UP OPTIMIZED
  -----------------------------------------

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] previous = new int[n];
        for(int row = 0; row < m; row++) {
            int[] current = new int[n];
            for(int column = 0; column < n; column++) {
                if(row == 0 && column != 0) {
                    current[column] = grid[row][column] + current[column - 1];
                    continue;
                }
                else if(row != 0 && column == 0) {
                    current[column] = grid[row][column] + previous[column];
                    continue;
                }
                if(row > 0 && column > 0) {
                    current[column] = grid[row][column] + Math.min(previous[column], current[column - 1]);
                }
            }
            previous = current;
        }
        return previous[n - 1];
    }
}
