package babbarArrayProblems;

/**
 * Array Problem 2: Find the Maximum and Minimum Element in an Array
 * ---------------------------------------------------------------
 * This file contains multiple approaches to find the minimum and maximum element in an array.
 *
 * Approaches Covered:
 * 1. Brute Force (Linear Search)
 * 2. Sorting
 * 3. Optimal Approach (Pairwise Comparison)
 *
 * For each approach, time complexity and explanation are provided.
 *
 * Example Array: {1000, 11, 445, 1, 330, 3000}
 *
 * Output:
 *   Minimum element is 1
 *   Maximum element is 3000
 */
public class Array_Problem_2 {
    /**
     * Approach 1: Brute Force (Linear Search)
     * ---------------------------------------
     * Traverse the array and update min and max variables.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static class Pair {
        int min;
        int max;
    }

    static Pair getMinMaxBruteForce(int[] arr) {
        Pair minmax = new Pair();
        minmax.min = arr[0];
        minmax.max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minmax.min) minmax.min = arr[i];
            if (arr[i] > minmax.max) minmax.max = arr[i];
        }
        return minmax;
    }

    /**
     * Approach 2: Sorting
     * -------------------
     * Sort the array, then min = arr[0], max = arr[n-1].
     * Time Complexity: O(n log n) (due to sorting)
     * Space Complexity: O(1) if in-place sort
     */
    static Pair getMinMaxSorting(int[] arr) {
        Pair minmax = new Pair();
        java.util.Arrays.sort(arr); // sorts in-place
        minmax.min = arr[0];
        minmax.max = arr[arr.length - 1];
        return minmax;
    }

    /**
     * Approach 3: Optimal (Pairwise Comparison)
     * -----------------------------------------
     * Compares elements in pairs, reducing the number of comparisons.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * If n is even: 1 initial comparison + 3(n-2)/2 comparisons
     * If n is odd: 0 initial + 3(n-1)/2 comparisons
     */
    static Pair getMinMaxOptimal(int[] arr) {
        Pair minmax = new Pair();
        int n = arr.length;
        int i;
        // If array has even number of elements
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.max = arr[1];
                minmax.min = arr[0];
            }
            i = 2;
        } else {
            // If odd, initialize both as first element
            minmax.max = arr[0];
            minmax.min = arr[0];
            i = 1;
        }
        // Compare in pairs
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax.max) minmax.max = arr[i];
                if (arr[i + 1] < minmax.min) minmax.min = arr[i + 1];
            } else {
                if (arr[i + 1] > minmax.max) minmax.max = arr[i + 1];
                if (arr[i] < minmax.min) minmax.min = arr[i];
            }
            i += 2;
        }
        return minmax;
    }

    /**
     * Main method to demonstrate all approaches with example array.
     */
    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        System.out.println("Example Array: java.util.Arrays.toString(arr)");

        // Brute Force
        Pair brute = getMinMaxBruteForce(arr.clone());
        System.out.printf("[Brute Force] Min: %d, Max: %d\n", brute.min, brute.max);

        // Sorting
        Pair sorted = getMinMaxSorting(arr.clone());
        System.out.printf("[Sorting] Min: %d, Max: %d\n", sorted.min, sorted.max);

        // Optimal
        Pair optimal = getMinMaxOptimal(arr.clone());
        System.out.printf("[Optimal] Min: %d, Max: %d\n", optimal.min, optimal.max);
    }
}

