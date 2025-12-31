package dp;

// Problem: Longest repeated subsequence
public class DP_Problem_15 {

    public static int lrs(String str) {
        int n = str.length();

        // Create a DP table to store lengths of LCS (Longest Common Subsequence) for
        // all substrings
        int[][] dp = new int[n + 1][n + 1];

        // Fill the DP table considering the constraint that characters with the same
        // indices cannot form a subsequence
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Increment if characters match and indices differ
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take the maximum from previous subproblems
                }
            }
        }

        // Return the LRS length from the bottom right corner of the DP table
        return dp[n][n];
    }

    public static void main(String[] args) {
        String str = "aab";

        int lrsLength = lrs(str);
        System.out.println("Length of Longest Repeated Subsequence: " + lrsLength);
    }
}
