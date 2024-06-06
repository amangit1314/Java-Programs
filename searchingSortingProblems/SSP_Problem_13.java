package searchingSortingProblems;

import java.util.Arrays;

// Count triplet with sum smaller than a given value
public class SSP_Problem_13 {
    public static int countTriplets(int[] arr, int target) {
        if (arr == null || arr.length < 3) {
            return 0; // Handle invalid input (array must have at least 3 elements)
        }

        int count = 0;
        int n = arr.length;

        // Sort the array for efficient lookups
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            // Fix the first element `arr[i]`
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target) {
                    // Count all possible triplets with `arr[i]` as the first element
                    count += right - left;
                    left++;
                } else {
                    // Move right pointer to decrease the sum if it exceeds the target
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 3, 4, 7 };
        int target = 12;
        int tripletCount = countTriplets(arr, target);
        System.out.println("Number of triplets with sum less than " + target + ": " + tripletCount);
    }
}
