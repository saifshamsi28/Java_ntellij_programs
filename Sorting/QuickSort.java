package Sorting;
import java.util.Scanner;
public class QuickSort {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        while (true) {
            while (i <= high && arr[i] <= pivot) {
                i++;
            }
            while (j >= low && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                break;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.print("Enter the elements of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        int low = 0;
        int high = size - 1;
        quickSort(arr, low, high);
        System.out.println("The sorted array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}

