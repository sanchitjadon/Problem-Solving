class Solution {
    public static boolean canWePlace(int stalls[],int dist,int k){
        int countCows=1;
        int last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=dist){
                countCows++;
                last=stalls[i];
            }
            if(countCows>=k){
                return true;
            }
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low=1;
        int high=stalls[n-1]-stalls[0];
        while(low<=high){
            int mid=(low+high)/2;
            if(canWePlace(stalls,mid,k)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
}
