 class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {
        int m=n1.length;
        int n=n2.length;
        int t=m+n;
        if(m>n)
          return findMedianSortedArrays(n2,n1);

        int l=0;
        int r=m;
        int half=(t+1)/2;
        double result=0.0;
        while(l<=r){
            int mid=l+(r-l)/2;
            int left=half-mid;
            int l1,l2,r1,r2;
            if(mid>0){l1=n1[mid-1];}else{l1=Integer.MIN_VALUE;}
            if(mid<m){r1=n1[mid];}else{r1=Integer.MAX_VALUE;}
            if(left>0){l2=n2[left-1];}else{l2=Integer.MIN_VALUE;}
            if(left<n){r2=n2[left];}else{r2=Integer.MAX_VALUE;}
            if( l1<=r2  &&  l2<=r1 ){
                //even
                if(t%2==0){
                    result=((Math.max(l1,l2)+Math.min(r1,r2))/2.0);
                }
                else{
                    result= Math.max(l1,l2);
                }
                break;
            }
            else if(l1>r2){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return result;
    }
}
