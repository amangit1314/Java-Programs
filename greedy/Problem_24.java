package greedy;

// Chocolate Distribution Problem

public class Problem_24 {
    public static int findMinDiff(int[] arr, int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        }

        // Sort the array
        java.util.Arrays.sort(arr);

        // Initialize the minimum difference
        int minDiff = Integer.MAX_VALUE;

        // Find the minimum difference
        for (int i = 0; i <= n - m; i++) {
            int diff = arr[i + m - 1] - arr[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7; // Number of students
        int n = arr.length;

        int result = findMinDiff(arr, n, m);
        System.out.println("Minimum difference is: " + result);
    }
}
     