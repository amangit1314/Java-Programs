package dp;

// Problem: Longest subsequence such that difference between adjacent elements is exactly one
public class DP_Problem_21 {

    /**
     * Approach:
     * 
     * 1. We want the longest subsequence (not necessarily contiguous) where
     *    the difference between adjacent elements is 1.
     * 
     * 2. Use Dynamic Programming:
     *    - dp[i] = length of the longest subsequence ending at index i
     *    - Initially, dp[i] = 1 (single element itself)
     *    - For each i, check all j < i:
     *        if abs(arr[i] - arr[j]) == 1, we can append arr[i] after arr[j]
     *        dp[i] = max(dp[i], dp[j] + 1)
     * 
     * 3. Finally, the answer is max(dp[i]) over all i
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */

    public static int longestSubseqDiffOne(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] dp = new int[n];

        // Each element itself is a subsequence of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Fill dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if current element can be appended after arr[j]
                if (Math.abs(arr[i] - arr[j]) == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find maximum value in dp array
        int maxLen = dp[0];
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 3, 2, 1 };
        
        int maxLen = longestSubseqDiffOne(arr);
        System.out.println("Length of longest subsequence with adjacent difference 1: " + maxLen);
    }
}
