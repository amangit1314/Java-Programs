package miscellaneous.aoa_lab;
// Java program to implement Optimal File Merge Pattern

import java.util.*;

public class Optimal {

    // Function to find minimum computation
    static int minComputation(int size, int[] files) {

        // create a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            // add sizes to priorityQueue
            pq.add(files[i]);
        }

        // variable to count total computations
        int count = 0;

        while (pq.size() > 1) {

            // pop two smallest size element from the min heap
            int temp = pq.poll() + pq.poll();

            // add the current computations with the previous one's
            count += temp;

            // add new combined file size to priority queue or min heap
            pq.add(temp);
            System.out.println(temp);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // no of files
        int size = sc.nextInt();

        int[] files = new int[size];
        for(int i = 0; i < size; i++){
            files[i] = sc.nextInt();
            System.out.print(files[i] + " ");
        }

        // total no of computations do be done final answer
        System.out.println("Minimum Computations = " + minComputation(size, files));
    }
}

