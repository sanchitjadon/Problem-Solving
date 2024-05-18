//recursion
class Solution {
    public int countways(int dice,int face,int target){
        if(target<0){
            return 0;
        }
        if(dice==0 && target!=0){
            return 0;
        }
        if(dice!=0 && target==0){
            return 0;
        }
        if(dice==0 && target==0){
            return 1;
        }
        int ans=0;
        for(int i=1;i<=face;i++){
            ans=(int)((ans+countways(dice-1,face,target-i))%1000000007);
        }
        return ans;
    }
    public int numRollsToTarget(int n, int k, int target) {
        return countways(n,k,target);
    }
}

// TOP DOWN + MEMO
class Solution {
    public int countways(int dice,int face,int target,int[][]dp){
        if(target<0){
            return 0;
        }
        if(dice==0 && target!=0){
            return 0;
        }
        if(dice!=0 && target==0){
            return 0;
        }
        if(dice==0 && target==0){
            return 1;
        }
        if(dp[dice][target]!=-1){
            return dp[dice][target];
        }
        int ans=0;
        for(int i=1;i<=face;i++){
            ans=(int)((ans+countways(dice-1,face,target-i,dp))%1000000007);
        }
        dp[dice][target]=ans;
        return dp[dice][target];
    }
    public int numRollsToTarget(int n, int k, int target) {
        int [][]dp=new int[n+1][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return countways(n,k,target,dp);
    }
}
