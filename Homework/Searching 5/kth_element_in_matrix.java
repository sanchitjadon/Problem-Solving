class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        int[]arr=new int[n*n];
        int x=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[x]=mat[i][j];
                x++;
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}
