// Longest Palindromic SubString

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_43 {
    static int longestPalindromicSubstr(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;

        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    if (cl == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && cl > maxLength) {
                    maxLength = cl;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Length of Longest Palindromic Substring is: " + longestPalindromicSubstr(str));
        sc.close();
    } 
}
       