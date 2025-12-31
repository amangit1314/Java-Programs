package dp;

// Problem: lcs of three strings
public class DP_Problem_18 {
    public static int lcsOfThree(String str1, String str2, String str3) {
        int m = str1.length();
        int n = str2.length();
        int o = str3.length();

        // 3D DP table to store LCS lengths for substrings
        int[][][] dp = new int[m + 1][n + 1][o + 1];

        // Base cases: empty substrings have LCS of 0
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= o; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 0;
                    }
                }
            }
        }

        // Fill the DP table iteratively
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= o; k++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1) && str1.charAt(i - 1) == str3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1; // All three characters match, increment LCS
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                        // Choose the maximum LCS from considering only two of the strings
                    }
                }
            }
        }

        return dp[m][n][o]; // LCS length of the entire strings
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        String str3 = "AGAFABD";

        int lcsLength = lcsOfThree(str1, str2, str3);
        System.out.println("Length of LCS of three strings: " + lcsLength);
    }
}
