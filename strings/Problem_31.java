package strings;

public class Problem_31 {
    public static int lcs(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
    
        // Create a DP table to store LCS lengths
        int[][] dp = new int[m + 1][n + 1];
    
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
              dp[i][j] = dp[i - 1][j - 1] + 1; // Match, add 1 to LCS length
            } else {
              dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Choose the larger LCS from previous calculations
            }
          }
        }
    
        return dp[m][n]; // LCS length is in the bottom right corner of the DP table
      }
    
      public static void main(String[] args) {
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";
    
        int lcsLength = lcs(text1, text2);
        System.out.println("Length of LCS for '" + text1 + "' and '" + text2 + "' is: " + lcsLength);
      }
}
