package searchingSortingProblems;

import java.util.HashMap;

// Subarray with zero sum
public class SSP_Problem_15 {
    public static void printSubarraysWithZeroSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return; // Handle empty array
        }

        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int currentSum = 0;
        sumMap.put(0, 1); // Special case: empty subarray with sum 0

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // If the current sum has already been seen, it means the subarray
            // from the previous occurrence of that sum to the current element
            // has a sum of zero. Print all such subarrays.
            if (sumMap.containsKey(currentSum)) {
                int startIndex = currentSum - sumMap.get(currentSum);
                for (int j = startIndex; j <= i; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println(); // Print a newline after each subarray
            }

            // Update the map to store the current sum and its first occurrence
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -4, 2, -2, 7 };
        System.out.println("Subarrays with zero sum:");
        printSubarraysWithZeroSum(arr);
    }
}
