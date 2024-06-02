class Solution {
    //           Recursion approach
    //          ----------------------
    
    public int recurrenceLIS(int[] nums,int idx,int prev){
        if(idx==nums.length){
            return 0;
        }
        int take=0;
        if(prev==-1 || nums[idx]>nums[prev]){
            take=1+recurrenceLIS(nums,idx+1,idx);
        }
        int nottake=recurrenceLIS(nums,idx+1,prev);
        return Math.max(take,nottake);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        return recurrenceLIS(nums,0,-1);
    }
    



    //         Memoization
    //        --------------
    

    public int LIS(int []nums,int idx,int prev,int[][]dp){
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int take=0;
        if(prev==-1 || nums[idx]>nums[prev]){
            take=1+LIS(nums,idx+1,idx,dp);
        }
        int nottake=LIS(nums,idx+1,prev,dp);
        dp[idx][prev+1]= Math.max(take,nottake);
        return dp[idx][prev+1];
    }
    public int lengthOfLIS(int[]nums){
        int n=nums.length;
        int[][]dp=new int[n][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return LIS(nums,0,-1,dp);
    }
    



    //          Bottom up
    //        --------------

    
    public int lengthOfLIS(int[]nums){
        int n=nums.length;
        if(n==1){
            return 1;
        }
        int []dp=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=1;
        int maxLISLength=0;
        for(int i=1;i<n;i++){
            int maxPrevLIS=0;
            for(int j=0;j<=i-1;j++){
                if(nums[i]>nums[j]){
                    maxPrevLIS=Math.max(maxPrevLIS,dp[j]);
                }
            }
            dp[i]=maxPrevLIS+1;
            maxLISLength=Math.max(maxLISLength,dp[i]);
        }
        return maxLISLength;
    }
    



    //        Bottom up optimization with Binary Search
    //        ------------------------------------------
    public int binarySearch(List<Integer>lis,int x){
        int i=0;
        int j=lis.size()-1;
        int idx=lis.size();
        while(i<=j){
            int mid=i+(j-i)/2;
            if(lis.get(mid)<x){
                i=mid+1;
            }
            else{
                idx=mid;
                j=mid-1;
            }
        }
        return idx;
    }
    public int lengthOfLIS(int []nums){
        int n=nums.length;
        List<Integer>lisStore=new ArrayList<>();
        lisStore.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>lisStore.get(lisStore.size()-1)){
                lisStore.add(nums[i]);
            }
            else{
                int idx=binarySearch(lisStore,nums[i]);
                lisStore.set(idx,nums[i]);
            }
        }
        return lisStore.size();
    }
}
