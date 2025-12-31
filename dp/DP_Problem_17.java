package dp;

// space optimized LCS
public class DP_Problem_17 {
    public static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Only need two rows (current and previous) for space optimization
        int[] dp = new int[n + 1];

        int maxLength = 0;

        // Iterate for rows (considering str1 as the reference)
        for (int i = 1; i <= m; i++) {
            int prev = dp[0]; // Store the previous row's value for the first element in the current row

            // Iterate for columns (considering str2 as the moving string)
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // Store the current element's value from the previous row

                // Update dp[j] based on LCS logic
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[j] = prev + 1; // If characters match, add 1 to the diagonal element from the previous row
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]); // Choose the maximum from the current element in the previous
                                                        // row or the element to its left
                }

                maxLength = Math.max(maxLength, dp[j]); // Update maxLength as needed

                prev = temp; // Update prev for the next iteration in the current row
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int lcsLength = lcs(str1, str2);
        System.out.println("Length of Longest Common Subsequence: " + lcsLength);
    }
}
