class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int i=0;
        int j=arr.length-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while(i<=j){
            int m=i+(j-i)/2;
            if(arr[i]<=arr[j]){
                if(arr[i]<ans){
                    index=i;
                    ans=arr[i];
                }
                break;
            }
            else if(arr[i]<=arr[m]){
                if(arr[i]<ans){
                    index=i;
                    ans=arr[i];
                }
                i=m+1;
            }
            else{
                if(arr[m]<ans){
                    index=m;
                    ans=arr[m];
                }
                j=m-1;
            }
        }
        return index;
    }
}
