import java.util.Arrays;
import java.util.Scanner;

public class C_Counting2_AtCoder {
    public static void counting(int arr[],int x){
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        if(arr[i]==x){
            System.out.println(arr.length);
            return;
        }
        if(arr[j]==x){
            System.out.println(1);
            return;
        }
        if(arr[j]<x){
            System.out.println(0);
            return;
        }
        i++;
        j--;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(arr[mid]<=x&&arr[mid+1]>x){
                System.out.println(arr.length-mid);
                return;
            }
            else if(arr[mid]>x){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        System.out.println(0);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size= sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i]= sc.nextInt();
        }
        int t= sc.nextInt();
        for(int i=1;i<=t;i++){
            int x=sc.nextInt();
            counting(arr,x);
        }
    }
}
