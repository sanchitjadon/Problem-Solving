//recursion
class Solution {
    public int jumpHelper(int[]arr,int start){
        if(start>=arr.length-1){
            return 0;
        }
        if(arr[start]==0){
            return 1+jumpHelper(arr,start+1);
        }
        int minJump=Integer.MAX_VALUE;
        for(int i=start+1;i<=start+arr[start];i++){
            minJump=Math.min(minJump,1+jumpHelper(arr,i));       
        }
        return minJump;
    }
    public int jump(int[] nums) {
        return jumpHelper(nums,0);
    }
}

// memoization              tc->O(n*k) where k is max possible jump in worst case
//                            sc->O(n)+O(n)
class Solution {
    public int jumpHelper(int[]arr,int start,int[]dp){
        if(start>=arr.length-1){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        if(arr[start]==0){
            dp[start]= 1+jumpHelper(arr,start+1,dp);
            return dp[start];
        }
        int minJump=Integer.MAX_VALUE;
        for(int i=start+1;i<=start+arr[start];i++){
            minJump=Math.min(minJump,1+jumpHelper(arr,i,dp));       
        }
        dp[start]= minJump;
        return dp[start];
    }
    public int jump(int[] nums) {
        int []dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return jumpHelper(nums,0,dp);
    }
}

//Bottom up
