package babbarArrayProblems;
import java.util.Arrays;

/**
 * Array Problem 4: Merge Two Sorted Arrays
 * ---------------------------------------
 * This file contains multiple approaches to merge two sorted arrays.
 *
 * Approaches Covered:
 * 1. Brute Force (Using a temporary array)
 * 2. Sorting
 * 3. Optimal Approach (In-place merging)
 *
 * For each approach, time complexity and explanation are provided.
 *
 * Example Arrays:
 *   arr1: {1, 5, 9, 10, 15, 20}
 *   arr2: {2, 3, 8, 13}
 *
 * Output:
 *   After Merging First Array: [1, 2, 3, 5, 8, 9]
 *   Second Array: [10, 13, 15, 20]
 */
public class Array_Problem_4_Approach2 {

    static int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
    static int arr2[] = new int[]{2, 3, 8, 13};

    /**
     * Approach 1: Brute Force (Using a temporary array)
     * ------------------------------------------------
     * Create a new array and merge elements from both arrays.
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     */
    public static int[] mergeBruteForce(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < m) {
            result[k++] = arr1[i++];
        }
        while (j < n) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    /**
     * Approach 2: Sorting
     * -------------------
     * Concatenate arrays and sort.
     * Time Complexity: O((n + m) log (n + m))
     * Space Complexity: O(n + m)
     */
    public static int[] mergeSorting(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] result = new int[m + n];
        System.arraycopy(arr1, 0, result, 0, m);
        System.arraycopy(arr2, 0, result, m, n);
        Arrays.sort(result);
        return result;
    }

    /**
     * Approach 3: Optimal (In-place merging)
     * --------------------------------------
     * Merge arrays in-place without extra space.
     * Time Complexity: O(n * m)
     * Space Complexity: O(1)
     */
    static void merge(int m, int n) {
        for (int i = n - 1; i >= 0; i--) {
            int j, last = arr1[m - 1];
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }
            if (j != m - 2 || last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }

    /**
     * Main method to demonstrate all approaches with example arrays.
     */
    public static void main(String[] args) {
        System.out.println("Original Arrays:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));

        // Brute Force
        int[] bruteResult = mergeBruteForce(arr1.clone(), arr2.clone());
        System.out.println("After Merging (Brute Force): " + Arrays.toString(bruteResult));

        // Sorting
        int[] sortedResult = mergeSorting(arr1.clone(), arr2.clone());
        System.out.println("After Merging (Sorting): " + Arrays.toString(sortedResult));

        // Optimal
        merge(arr1.length, arr2.length);
        System.out.println("After Merging (Optimal):");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }
}
