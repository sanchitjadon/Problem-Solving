// Recursion
// tc-O(n*(n^1/2))
// sc-O(n)

class Solution {
    public int ways(int n){
        if(n==0){
            return 0;
        }
        int min=n;
        for(int i=1;i*i<=n;i++){
            min=Math.min(min,1+ways(n-(i*i)));
        }
        return min;
    }
    public int numSquares(int n) {
        return ways(n);
    }
}


// top down + Memoization
// tc=~O(n)
// sc=O(n)+O(n)
class Solution{
    public int ways(int n,int[]dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int min=n;
        for(int i=1;i*i<=n;i++){
            min=Math.min(min,1+ways(n-(i*i),dp));
        }
        dp[n]=min;
        return dp[n];
    }
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return ways(n,dp);
    }
}

// Bottom Up
// tc=O(n)
// sc=O(n)
class Solution{
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=n;j++){
                if(i-(j*j)>=0){
                    dp[i]=Math.min(dp[i],1+dp[i-(j*j)]);
                }              
            }
        }
        return dp[n];
    }
}
