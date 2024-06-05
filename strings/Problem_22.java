package strings;

// Count All Palindromic Subsequence in a given String.
public class Problem_22 {
    public static int countPalindromicSubsequences(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        // Single-character strings are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Consider substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = 2; // Two possibilities: single character or both characters
            } else {
                dp[i][i + 1] = 1; // Only single character is a palindrome
            }
        }

        // Fill the DP table for substrings of length 3 or more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2; // Include the current pair and exclude the pair
                    // +2 accounts for single character palindromes at i and j (already counted in
                    // dp)
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    // Exclude the current pair, consider palindromes without current characters
                }
            }
        }

        // dp[0][n - 1] contains the total count of palindromic subsequences
        return dp[0][n - 1];
    }

    public static int countPalindromicSubsequences(String str, int start, int end) {
        if (start == end) {
            return 1; // Single character is a palindrome subsequence
        }

        if (start > end) {
            return 0; // Empty string has no subsequences
        }

        int count = 0;

        // Case 1: Include the current character
        if (str.charAt(start) == str.charAt(end)) {
            count = countPalindromicSubsequences(str, start + 1, end - 1) + 1; // Include the pair and exclude the pair
        } else {
            count = countPalindromicSubsequences(str, start + 1, end); // Exclude the current character
        }

        // Case 2: Exclude the current character
        count += countPalindromicSubsequences(str, start, end - 1);

        return count;
    }

    public static int countPalindromicSubsequencesWithoutDP(String str) {
        return countPalindromicSubsequences(str, 0, str.length() - 1);
    }
    public static void main(String[] args) {
        String str = "aabcb";
        int count = countPalindromicSubsequences(str);
        System.out.println("Total palindromic subsequences in " + str + ": " + count);
    }
}
