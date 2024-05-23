package Sorting;
import java.util.Arrays;
import java.util.Scanner;
 public class BinarySearch{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size=sc.nextInt();
        int []arr=new int[size];
        System.out.println("Enter the elements of array: ");
        for(int i=0;i<arr.length;i++){
            int ele=sc.nextInt();
            arr[i]=ele;
        }
        Arrays.sort(arr); // sorts the array in ascending order
        System.out.println("Provided array is:- ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\nEnter the element to be search: ");
        int key= sc.nextInt();
        int result=searchElement(arr,key);
        if(result==-1){
            System.out.println("\nElement not found");
        }
        else {
            System.out.println("\nElement "+key+" is found at position "+(result+1));   // position = index +1
        }
    }
     public static int searchElement(int []arr,int elementToBeSearch){
         int start=0,end=(arr.length-1);
         int mid=(start+end)/2;
         while (start<=end) {
             if (arr[mid] > elementToBeSearch) {
                 end = mid-1;
             } else if (arr[mid]==elementToBeSearch) {
                 return mid;
             } else {
                 start=mid+1;
             }
             mid=(start+end)/2;
         }
         return -1;
     }
}
