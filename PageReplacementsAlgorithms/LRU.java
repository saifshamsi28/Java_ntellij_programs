package PageReplacementsAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class LRU {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number frames: ");
        int numberOfFrames = sc.nextInt();
        int arr[] = {1,2,3,4,5,1, 3, 1, 6, 3, 2,3};

        // To represent set of current pages.We use an Arraylist
        ArrayList<Integer> s=new ArrayList<>(numberOfFrames);
        int count=0;
        int page_faults=0;
        int page_hits=0;
        for(int i:arr)
        {
            // Insert it into set if not present
            // already which represents page fault
            if(!s.contains(i))
            {
                // Check if the set can hold equal pages
                if(s.size()==numberOfFrames)
                {
                    s.remove(0);
                    s.add(numberOfFrames-1,i);
                }
                else
                    s.add(count,i);
                page_faults++;
                ++count;
            }
            else
            {
                // Remove the indexes page
                s.remove((Object)i);
                // insert the current page
                s.add(s.size(),i);
            }
        }
        page_hits=arr.length-page_faults;
        System.out.println("Length of reference string: "+arr.length);
        System.out.println("Page faults: "+page_faults);
        System.out.println("Page hits: "+page_hits);
    }
}
