class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int i=0;
        int j=nums.length-1;
        if(nums[i]!=nums[i+1]){
            return nums[i];
        }
        if(nums[j]!=nums[j-1]){
            return nums[j];
        }
        i++;
        j--;
        while(i<j){
            int mid=i+(j-i)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            else if(mid%2==0){
                if(nums[mid]==nums[mid-1]){
                    j=mid-1;
                }
                else{
                    i=mid+1;
                }
            }
            else{
                if(nums[mid]==nums[mid-1]){
                    i=mid+1;
                }
                else{
                    j=mid-1;
                }
            }
        }
        return nums[i];
    }
}
