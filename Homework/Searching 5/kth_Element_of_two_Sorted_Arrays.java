import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        if(n>m)
           return kthElement(arr2, arr1, m, n, k);
        int low=Math.max(0,k-m);
        int high=Math.min(n,k);
        int leftElements=k;
        int ans=0;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=leftElements-mid1;
            int l1,l2,r1,r2;
            if(mid1>0){l1=arr1.get(mid1-1);}else{l1=Integer.MIN_VALUE;}
            if(mid1<n){r1=arr1.get(mid1);}else{r1=Integer.MAX_VALUE;}
            if(mid2>0){l2=arr2.get(mid2-1);}else{l2=Integer.MIN_VALUE;}
            if(mid2<m){r2=arr2.get(mid2);}else{r2=Integer.MAX_VALUE;}

            if(l1<=r2 && l2<=r1){
                ans=Math.max(l1,l2);
                break;
            }
            if(l1>r2){
                high=mid1-1;
            }
            if(l2>r1){
                low=mid1+1;
            }
        }
        return ans;
    }
}
