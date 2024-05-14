
//Recursion
class Solution{
    static int find(int idx,int [][]mat){
        if(idx<0){
            return 0;
        }
        int take=Math.max(mat[0][idx],mat[1][idx])+find(idx-2,mat);
        int nontake=find(idx-1,mat);
        return Math.max(take,nontake);
    }
    static int maxSum(int N, int mat[][])
    {
        return find(N-1,mat);
    }
}

// Top down + Memo
class Solution{
    static int find(int idx,int [][]mat,int[]dp){
        if(idx<0){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int take=Math.max(mat[0][idx],mat[1][idx])+find(idx-2,mat,dp);
        int nontake=find(idx-1,mat,dp);
        dp[idx]= Math.max(take,nontake);
        return dp[idx];
    }
    static int maxSum(int N, int mat[][])
    {   
        int []dp=new int[N];
        Arrays.fill(dp,-1);
        return find(N-1,mat,dp);
    }
}

// Bottom up
class Solution{
    static int maxSum(int N, int mat[][])
    {
        // code here
        int []dp=new int[N];
        Arrays.fill(dp,-1);
        dp[0]=Math.max(mat[0][0],mat[1][0]);
        for(int i=1;i<N;i++){
            int take=Math.max(mat[0][i],mat[1][i]);
            if(i>1){
                take+=dp[i-2];
            }
            int nontake=dp[i-1];
            dp[i]=Math.max(take,nontake);
        }
        return dp[N-1];
    }
}
// Bottom up optimised
class Solution{
    static int maxSum(int N, int mat[][])
    {
        // code here
        int prev=Math.max(mat[0][0],mat[1][0]);
        int prev2=-1;
        for(int i=1;i<N;i++){
            int take=Math.max(mat[0][i],mat[1][i]);
            if(i>1){
                take+=prev2;
            }
            int nontake=prev;
            int curr=Math.max(take,nontake);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
