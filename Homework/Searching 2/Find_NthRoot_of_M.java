//Time complexity will be=O(log m)
//space complexity will be=O(1)

import java.util.Math;
class Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        int low=1;
        int high=m;
        while(low<=high){
            int mid=low+(high-low)/2;
            int x=(int)Math.pow(mid,n);
            if(x==m){
                return mid;
            }
            else if(x>m){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}


//Brute force-> linearly check 
//Time complexity=O(m)
