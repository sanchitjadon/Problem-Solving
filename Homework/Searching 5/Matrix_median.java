public class matrix_median {
   public static void main(String[] args) {
        int matrix[][]={{1,3,5},{2,6,9},{3,6,9}};
        int ans=matrixMedian(matrix);
        System.out.println(ans);
    }
   public static int matrixMedian(int matrix[][]){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            min=Math.min(min,matrix[i][0]);
        }
        for(int i=0;i<matrix.length;i++){
            max=Math.max(max,matrix[i][matrix[0].length-1]);
        }
        int low=min;
        int high=max;
        int required=(matrix.length*matrix[0].length)/2;
        while(low<=high){
            int mid=(low+high)/2;
            int numbers=NoLessThan(matrix,mid);
            if(numbers<=required){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    public static int upperBound(int arr[],int number){
        int i=0;
        int j= arr.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(arr[mid]<=number){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return i;
    }
    public static int NoLessThan(int matrix[][],int number){
        int count=0;
        for(int i=0;i<matrix.length;i++){
            count+=upperBound(matrix[i],number);
        }
        return count;
    }
}
