 // brute force Solution

 //fails when substring found in middle for e.g  s=krrgw  t=zjxss      output =1    expected=2
    public static int equalSubstring(String s,String t,int maxCost){
         int i=0;
         while(i<s.length()){
             int val=Math.abs(s.charAt(i)-t.charAt(i));
             if(val<=maxCost){
                 i++;
                 maxCost=maxCost-val;
             }
             else{
                 break;
             }
         }
         return i;
    }


// O(n) time complexity 
// sliding window approach

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans=-1;
        int window=0;
        int i=0;
        int n=s.length();
        for(int j=0;j<n;j++){
            window=window+Math.abs(s.charAt(j)-t.charAt(j));
            while(window>maxCost){
                window=window-Math.abs(s.charAt(i)-t.charAt(i));
                i++;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}
