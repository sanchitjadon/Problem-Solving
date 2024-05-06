class Solution {
    //    [recursion]
         
    public int robbedMoney(int []nums,int idx){
        if(idx<=-1){
            return 0;
        }
        int take=nums[idx]+robbedMoney(nums,idx-2);
        int nontake=0+robbedMoney(nums,idx-1);
        return Math.max(take,nontake);
    }

    //      [Top Down + Memo]
    //       tc=O(n)
    //       sc=O(n)+O(n)
    public int robbery(int []nums,int idx,int[]dp){
        if(idx<=-1){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int take=nums[idx]+robbery(nums,idx-2,dp);
        int nontake=0+robbery(nums,idx-1,dp);
        dp[idx]=Math.max(take,nontake);
        return dp[idx];
    }
    public int rob(int[] nums) {
        int []dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return robbery(nums,nums.length-1,dp);
    }
    



    /*      [Bottom up]
    tc=O(n*(n-2))
    sc=O(n)
    */
    // dp[i]= max loot till (i)th house 
    // dp[i]= max loot till (i-2)th house + loot of ith house
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int []dp=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        dp[1]=nums[1];
        for(int i=2;i<=n-1;i++){
            int maxtillprev2Home=Integer.MIN_VALUE;
            for(int j=0;j<=i-2;j++){
                maxtillprev2Home=Math.max(maxtillprev2Home,dp[j]);
            }
            dp[i]=maxtillprev2Home+nums[i];
        }
        int maxLoot=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxLoot=Math.max(maxLoot,dp[i]);
        }
        return maxLoot;
    }
}
