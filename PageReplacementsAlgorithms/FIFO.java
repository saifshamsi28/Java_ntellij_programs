package PageReplacementsAlgorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FIFO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of frames: ");
        int numberOfFrames = sc.nextInt();
        int arr[] = {1,2,3,4,5,1, 3, 1, 6, 3, 2,3};

        Queue<Integer> queue = new LinkedList<>();
        int pageFaults = 0;
        int pageHits = 0;

        for (int i : arr) {
            if (queue.contains(i)) {
                // Page hit
                pageHits++;
            } else {
                // Page fault
                if (queue.size() == numberOfFrames) {
                    queue.poll(); // Remove the oldest page from the queue
                }
                queue.add(i);
                pageFaults++;
            }
        }

        System.out.println("Length of reference string: " + arr.length);
        System.out.println("Page faults: " + pageFaults);
        System.out.println("Page hits: " + pageHits);
    }
}
