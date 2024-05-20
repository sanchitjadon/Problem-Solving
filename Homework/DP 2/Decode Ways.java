//                     Recursive approach 
//----------------------------------------------------------
class Solution {
    public int ways(String s,int idx){
        if(idx==s.length()){
            return 1;
        }
        if(s.charAt(idx)=='0'){
            return 0;
        }
        if(idx==s.length()-1){
            return 1;
        }
        int ans=ways(s,idx+1);
        if((s.charAt(idx)-'0')*10+(s.charAt(idx+1)-'0')<=26){
            ans+=ways(s,idx+2);
        }
        return ans;
    }
    public int numDecodings(String s) {
        return ways(s,0);
    }
}

//                    TOP DOWN + MEMO
//------------------------------------------------------------------------
class Solution {
    public int ways(String s,int idx,int[]dp){
        if(idx==s.length()){
            return 1;
        }
        if(s.charAt(idx)=='0'){
            return 0;
        }
        if(idx==s.length()-1){
            return 1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=ways(s,idx+1,dp);
        if((s.charAt(idx)-'0')*10+(s.charAt(idx+1)-'0')<=26){
            ans+=ways(s,idx+2,dp);
        }
        return dp[idx]=ans;
    }
    public int numDecodings(String s) {
        int[]dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return ways(s,0,dp);
    }
}


//               TABULAR (Bottom Up)
//-------------------------------------------------------------------
class Solution{
    public int numDecodings(String s) {
        int n=s.length();
        int[]dp=new int[n+1];
        //Arrays.fill(dp,-1);   ----- we don't want to subtract 1 from our result every time
        dp[n]=1;
        dp[n-1]=(s.charAt(n-1)=='0')?0:1;
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)=='0'){
                continue;
            }
          //contribute independently
            dp[i]+=dp[i+1];
          //contribute with next character
            if((s.charAt(i)-'0')*10+(s.charAt(i+1)-'0')<=26){
                dp[i]+=dp[i+2];
            }
        }
        return dp[0];
    }
}
