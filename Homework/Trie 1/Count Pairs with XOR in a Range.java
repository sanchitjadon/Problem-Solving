// Brute Force:
// Time Complexity=O(n2)
// space complexity=O(1)

class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int xor=nums[i]^nums[j];
                if(xor>=low && xor<=high){
                    count++;
                }
            }
        }
        return count;
    }
}


