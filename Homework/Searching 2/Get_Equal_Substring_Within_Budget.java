 // brute force Solution
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
