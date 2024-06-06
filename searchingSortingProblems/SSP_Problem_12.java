
package searchingSortingProblems;

// 	maximum sum such that no 2 elements are adjacent
public class SSP_Problem_12 {
    public static int maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // Handle empty array
        }

        int n = arr.length;

        // Initialize DP array to store maximum sum ending at each index
        int[] dp = new int[n];

        // Base cases
        dp[0] = arr[0]; // Maximum sum with only the first element
        if (n >= 2) {
            dp[1] = Math.max(arr[0], arr[1]); // Maximum of first two elements
        }

        // Fill the DP table using the recurrence relation
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }

        // Return the maximum sum (either ending at n-1 or n-2)
        return Math.max(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 9, 4, 5, 0 };
        int maxSum = maxSum(arr);
        System.out.println("Maximum sum such that no two elements are adjacent: " + maxSum);
    }
}