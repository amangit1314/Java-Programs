package searchingSortingProblems;

import java.util.PriorityQueue;

// find kth smallest element

public class SSP_Problem_21 {
    public static int findKthSmallest(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num); // Add elements to the min-heap (smallest on top)
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the largest element if heap size exceeds k
            }
        }

        return minHeap.peek(); // Kth smallest element is the minimum in the min-heap
    }

    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 3;

        int kthSmallest = findKthSmallest(arr, k);
        System.out.println("Kth smallest number (" + k + "): " + kthSmallest);
    }
}
