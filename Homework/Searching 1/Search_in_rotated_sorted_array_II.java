//There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
// Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

// You must decrease the overall operation steps as much as possible.

// Example 1:
// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true

// Example 2:
// Input: nums = [2,5,6,0,0,1,2], target = 3
// Output: false
 
// Constraints:
// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// nums is guaranteed to be rotated at some pivot.
//-104 <= target <= 104

// IN THE SEARCH IN ROTATED SORTED ARRAY 1 , ALL ELEMENTS IN ARRAY ARE DISTINCT BUT HERE DUPLICATES VALUES EXISTS
// ALL THE LOGIC OF 1 CAN BE IMPLEMENTED HERE BUT LOGIC CAN FAIL IN SOME EDGE TESTCASES WHERE DUPLICATE ELEMENTS MORE THAN HALF 
//ARRAY 
//FOR EXAMPLE :-[7,7,2,3,4,7,7,7,7,7,7]    HERE MID IS 7 AND LOW AND HIGH ARE 7 TOO . SO IT IMPOSSIBLE TO SAY WHICH HALF IS 
// SORTED AND WHICH IS NOT
// APPROACH IS TO TRIM DOWN THE ARRAY 

//CODE

class Solution {
    public boolean search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[low]==nums[mid]&&nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }
            else if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
}

// time complexity can be O(n/2) because of trimming 
