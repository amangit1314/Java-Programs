package strings;
import java.util.*;

// Problem Title => Find The Longest Recurring Subsequence in String

public class Problem_9 {

    // This function mainly returns LCS(str, str) with a condition that same characters at same index are not considered.
    static  int[][] dp = new int[1000][1000];

    // Longest Repeated Subsequence Problem
    static int findLongestRepeatingSubSeq(char[] X, int m, int n){

        if(dp[m][n] != -1)
            return dp[m][n];

        // return if we have reached the end of either string
        if(m == 0 || n == 0)
            return dp[m][n] = 0;

        // if characters at index m and n matches and index is different
        if (X[m - 1] == X[n - 1] && m != n)
            return dp[m][n] = findLongestRepeatingSubSeq(X, m - 1, n - 1) + 1;

        // else if characters at index m and n don't match
        return dp[m][n] = Math.max(findLongestRepeatingSubSeq(X, m, n - 1), findLongestRepeatingSubSeq(X, m - 1, n));
    }

    // Longest Repeated Subsequence Problem
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int m = sc.nextInt();
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println("The length of the largest subsequence that repeats itself is : " + findLongestRepeatingSubSeq(str.toCharArray(), m, m));
    }
}