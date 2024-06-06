package searchingSortingProblems;

import java.util.*;

public class SSP_Problem_17 {
    public static void sortBySetBitsCountingSort(int[] arr) {
        int n = arr.length;

        // Find the maximum number of set bits (useful for range in counting sort)
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, countSetBits(arr[i]));
        }

        // Create count arrays to store the frequency of elements with specific set bit
        // counts
        int[] count0 = new int[max + 1]; // Count for elements with 0 set bits
        // int[] count1 = new int[max + 1]; // Count for elements with 1 set bit
        // ... and so on for higher set bit counts (if needed)

        // Fill the count arrays based on set bit counts in the original array
        for (int i = 0; i < n; i++) {
            int setBits = countSetBits(arr[i]);
            count0[setBits]++; // Increment the count for the corresponding set bit count
        }

        // Reconstruct the sorted array using the count arrays
        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count0[i]; j++) {
                arr[index++] = i; // Fill the array with elements having 'i' set bits
            }
        }
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    // public static void sortBySetBitsComparator(int[] arr) {
    // Arrays.sort(arr, new Comparator<Integer>() {
    // @Override
    // public int compare(Integer a, Integer b) {
    // int setBitsA = countSetBits(a);
    // int setBitsB = countSetBits(b);

    // // Sort by set bit count first, then by original value (for stability)
    // if (setBitsA != setBitsB) {
    // return setBitsA - setBitsB;
    // } else {
    // return a - b; // Sort by original value if set bit count is the same
    // }
    // }
    // });
    // }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 4, 1, 7 };
        sortBySetBitsCountingSort(arr);
        System.out.println("Sorted array by set bit count: " + Arrays.toString(arr));
    }
}
