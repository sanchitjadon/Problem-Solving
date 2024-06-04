class Solution {
    private static final int MOD = 1000000007;
    
    public int numDecodings(String s) {
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) == '0') return 0;
        if(s.charAt(0) == '*') dp[1] = 9;
        else dp[1] = 1;
        
        for(int i=2; i<=s.length(); i++) {
            char curr = s.charAt(i-1);
            char prev = s.charAt(i-2);
            if(curr == '*') {
                dp[i] += 9*dp[i-1];
                if(prev == '1') dp[i] += 9*dp[i-2];
                else if(prev == '2') dp[i] += 6*dp[i-2];
                else if(prev == '*') dp[i] += 15*dp[i-2];
            } else {
                if(curr != '0') dp[i] += dp[i-1];
                if(prev == '1') dp[i] += dp[i-2];
                else if(prev == '2' && curr <= '6') dp[i] += dp[i-2];
                else if(prev == '*') {
                    if(curr <= '6') dp[i] += 2*dp[i-2];
                    else dp[i] += dp[i-2];
                }
            }
            dp[i] %= MOD;
        }
        return (int)dp[s.length()];
    }
} 
