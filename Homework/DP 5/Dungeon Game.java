class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = (dungeon[n-1][m-1] <= 0) ? Math.abs(dungeon[n-1][m-1]) + 1 : 1;
        for (int i = n-2; i >= 0; i--) {
            if (dungeon[i][m-1] <= 0) {
                dp[i][m-1] = Math.abs(dungeon[i][m-1]) + dp[i+1][m-1];
            } else {
                dp[i][m-1] = Math.max(1, dp[i+1][m-1] - dungeon[i][m-1]);
            }
        }
        for (int i = m-2; i >= 0; i--) {
            if (dungeon[n-1][i] <= 0) {
                dp[n-1][i] = Math.abs(dungeon[n-1][i]) + dp[n-1][i+1];
            } else {
                dp[n-1][i] = Math.max(1, dp[n-1][i+1] - dungeon[n-1][i]);
            }
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = m-2; j >= 0; j--) {
                if (dungeon[i][j] <= 0) {
                    dp[i][j] = Math.abs(dungeon[i][j]) + Math.min(dp[i+1][j], dp[i][j+1]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
