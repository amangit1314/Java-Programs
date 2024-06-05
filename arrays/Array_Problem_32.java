package arrays;

/**
 * This class finds the minimum number of operations required to make an array palindromic.
 */
public class Array_Problem_32 {

    /**
     * Calculates the minimum operations needed to make the given array a palindrome.
     *
     * @param arr The input array.
     * @param n The length of the array.
     * @return The minimum number of operations required.
     */
    public static int findMinOps(int[] arr, int n) {
        int minOperations = 0;

        // Iterate through the array from both ends, comparing elements.
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            if (arr[i] == arr[j]) {
                // Elements are already equal, no operation needed.
                continue;
            }

            // Decide which element needs to be incremented based on cost optimization:
            if (arr[i] < arr[j]) {
                // Add the difference to the smaller element (potentially cheaper).
                arr[i] += arr[j] - arr[i];
            } else {
                // Add the difference to the larger element.
                arr[j] += arr[i] - arr[j];
            }

            // Increment operation count.
            minOperations++;
        }

        return minOperations;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 9, 1};
        int minOps = findMinOps(arr, arr.length);
        System.out.println("Count of minimum operations is: " + minOps);
    }
}
