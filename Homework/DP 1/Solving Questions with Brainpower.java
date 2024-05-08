// Recursion

class Solution {
    public long ways(int[][]sj,int idx,int m){
        if(idx>=m){
            return 0;
        }
        long take=sj[idx][0]+ways(sj,idx+sj[idx][1]+1,m);
        long nontake=ways(sj,idx+1,m);
        return Math.max(take,nontake);
    }
    public long mostPoints(int[][] questions) {
        int m=questions.length;
        return ways(questions,0,m);
    }
}

// Top-Down + Memoization
// tc=O(n)
// sc=O(n)+O(n)
class Solution {
    public long ways(int[][]sj,int idx,int m,long []dp){
        if(idx>=m){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        long take=sj[idx][0]+ways(sj,idx+sj[idx][1]+1,m,dp);
        long nontake=ways(sj,idx+1,m,dp);
        dp[idx]= Math.max(take,nontake);
        return dp[idx];
    }
    public long mostPoints(int[][] questions) {
        int m=questions.length;
        long []dp=new long[m];
        Arrays.fill(dp,-1);
        return ways(questions,0,m,dp);
    }
}
