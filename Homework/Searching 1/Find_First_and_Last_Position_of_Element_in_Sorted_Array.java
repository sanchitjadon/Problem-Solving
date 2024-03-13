// Given an array of integers nums sorted in non-decreasing order, 
// find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]
 
// Constraints:
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

//CODE

class Solution {
    public static int firstOccurrence(int[]arr,int low,int high,int x,int n){
        if(low<=high){
             int mid=low+(high-low)/2;
            if((mid==0||x>arr[mid-1])&&arr[mid]==x){
                return mid;
            }          
            else if(arr[mid]<x) {
                return firstOccurrence(arr,mid+1,high,x,n);
            } else {
                return firstOccurrence(arr,low,mid-1,x,n);                
            }
        }
        return -1;
    }
     public static int lastOccurrence(int[]arr,int low,int high,int x,int n){
        if(low<=high){
            int mid=low+(high-low)/2;
            if((mid == arr.length - 1 || x < arr[mid + 1])&& arr[mid] == x){
                return mid;
            }
            else if(arr[mid]>x){
                return lastOccurrence(arr,low,mid-1,x,n);                
            }
            else{
                return lastOccurrence(arr,mid+1,high,x,n);
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int f=firstOccurrence(nums,0,nums.length-1,target,nums.length);
        int l=lastOccurrence(nums,0,nums.length-1,target,nums.length);
        int []ans={f,l};
        return ans;
    }

   public static void main(String[]args){
     Scanner sc=new Scanner(System.in);
     int size=sc.nextInt();
     int arr[]=new int[size];
     for(int i=0;i<size;i++){
         arr[i]=sc.nextInt();
     }
     int ans[]=new int[2];
     int target=sc.nextInt();
     ans=searchRange(arr,target);
     System.out.println("["+ans[0]+","+ans[1]+"[");
   }
}
