package dp;
// Problem: Max sum increasing subsequence
public class DP_Problem_19 {
    public static int maxSumIS(int[] arr) {
        int n = arr.length;

        // DP table to store the maximum sum ending at each index
        int[] dp = new int[n];

        // Base case: the first element is the maximum sum ending at itself
        dp[0] = arr[0];

        // Fill the DP table iteratively
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Consider including the current element if it increases the sum and creates an
                // increasing sequence
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        // Find the maximum sum in the DP table
        int maxSum = dp[0];
        for (int sum : dp) {
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 101, 2, 3, 100, 4, 5 };

        int maxSum = maxSumIS(arr);
        System.out.println("Maximum sum of increasing subsequence: " + maxSum);
    }
}
