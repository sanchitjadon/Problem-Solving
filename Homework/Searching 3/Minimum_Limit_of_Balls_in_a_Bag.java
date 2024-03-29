class Solution {
    public boolean findMinPenalty(int arr[],int penalty,int maxOperation){
        int operations=0;
        for(int i=0;i< arr.length;i++){
            if(arr[i]>penalty){
                if(arr[i]%penalty==0){
                    operations+=arr[i]/penalty-1;
                }
                else{
                    operations+=arr[i]/penalty;
                }
            }
        }
        return operations<=maxOperation;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int maxOfnums=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxOfnums=Math.max(maxOfnums,nums[i]);
        }
        int low=1;
        int high=maxOfnums;
        while(low<=high){
            int mid=(low+high)/2;
            if(findMinPenalty(nums,mid,maxOperations)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
