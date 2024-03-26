// Approach 1:-Brute Force
// time complexity=O(n*m)  &  space complexity=O(1)
 public static boolean search_nm(int matrix[][],int target){
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
 }

//Approach 2:- better
// time complexity=O(n*logm)  & space complexity=O(1)
class Solution{
    public static boolean search_n_PLUS_logm(int matrix[][],int target){
        for(int i=0;i< matrix.length;i++){
            if(matrix[i][0]<=target && target<=matrix[i][matrix[0].length-1]){
                return Bsearch(matrix[i],target);
            }
        }
        return false;
    }
    public static boolean Bsearch(int arr[],int target){
        int low=0;
        int high=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return true;
            }
            else if(arr[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
     }
}

//Approach 3:-best
// hypothetically treating it as a 1D array 
// search space= (0,0) to (n-1,m-1)
// every first element's row index is multiple of m 
// time complexity=O(lognm) & space complexity=O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int high=matrix.length*matrix[0].length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int row=mid/matrix[0].length;
            int cols=mid%matrix[0].length;
            if(matrix[row][cols]==target){
                return true;
            }
            else if(matrix[row][cols]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}
