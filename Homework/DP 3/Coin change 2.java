//Recursive solution
class Solution {
    public int findWays(int ind, int amount,int[] coins) {
        if(ind == 0) {
            if(amount % coins[0] == 0) return 1;
            else return 0;
        }
        int dontPick = 0 + findWays(ind-1,amount - 0 , coins);
        int pick = 0;
        if(coins[ind] <= amount) pick = findWays(ind,amount-coins[ind],coins);
        return dontPick + pick;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return findWays(n-1,amount,coins);
    }
}

//Top Down + Memo
class Solution {
    public int findWays(int ind, int amount,int[] coins,int[][] dp) {
        if(ind == 0) {
            if(amount % coins[0] == 0) return 1;
            else return 0;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        int dontPick = 0 + findWays(ind-1,amount - 0 , coins , dp);

        int pick = 0;
        if(coins[ind] <= amount) pick = findWays(ind,amount-coins[ind],coins ,dp);
        
        return dp[ind][amount] = dontPick + pick;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return findWays(n-1,amount,coins,dp);
    }
}

//bottom up
class Solution {
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
       
       for(int i = 0;i<=amount;i++) {
           if(i % coins[0] == 0) dp[0][i] = 1;
           else dp[0][i] = 0;
       }

       for(int i = 1;i<n;i++) {
           for(int j = 0;j<=amount;j++) {
               int dontPick = dp[i-1][j];
               int pick = 0;
               if(coins[i] <= j) pick = dp[i][j-coins[i]];
               dp[i][j] = dontPick + pick;
           }
       }
        return dp[n-1][amount];
    }
}
