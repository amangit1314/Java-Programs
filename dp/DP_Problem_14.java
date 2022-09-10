package dp;
import java.util.*;

public class DP_Problem_14 {

    public static int longestCommonSubsequence(String s1, String s2) {
        // <---- Space Optimized ------->
        return solveTabSo(s1, s2);

        // <-----Tabulation------------->
        // return solveTab(s1, s2);

        // <-----Memoization------------>
        // int[][] dp = new int[s1.length()][s2.length()];

        // for(int i = 0; i < s1.length(); i++ ){
        //   Arrays.fill(dp[i], -1);
        // }

        // return solveMem(s1, s2, 0, 0, dp);

        // <-----------Recursive-------->
        // return solve(s1, s2, 0, 0);
    }

    // recursive approach
    private static int solve(String a, String b, int i, int j) {
        // base case
        if(i == a.length())
            return 0;

        // base case
        if(j == b.length())
            return 0;

        int ans = 0;

        // if match
        if(a.charAt(i) == b.charAt(j))
            // and 1 + recursive call of i+1 and j+1
            ans = 1 + solve(a, b, i + 1, j + 1);

        // if not match
        else
            // max of recursive call for i+1, j and recursive call for i, j+1
            ans = Math.max(solve(a, b, i + 1, j), solve(a, b, i, j + 1));

        return ans;
    }

    // recursion + memoization (Top Down DP)
    private static int solveMem(String a, String b, int i, int j, int[][] dp) {
        // base case
        if(i == a.length())
            return 0;

        // base case
        if(j == b.length())
            return 0;

        int ans = 0;

        // memoization step 4 (check if the ans already exists, if yes then return the ans and don't process unnecessarily)
        if(dp[i][j] != -1)
            return dp[i][j];

        // if match
        if(a.charAt(i) == b.charAt(j))
            // and 1 + recursive call of i+1 and j+1
            // memoization step 3 (add dp in the recursive call)
            ans = 1 + solveMem(a, b, i + 1, j + 1, dp);

            // if not match
        else
            // max of recursive call for i+1, j and recursive call for i, j+1
            // memoization step 3 (add dp in the recursive call)
            ans = Math.max(solveMem(a, b, i + 1, j, dp), solveMem(a, b, i, j + 1, dp));

        // memoization step 5 ( store the ans in dp and then return the ans from dp)
        return dp[i][j] = ans;
    }

    // recursion + tabulation (Bottom Up DP)
    private static int solveTab(String a, String b) {
        // tabulation step 1 - create dp array
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        int ans = 0;

        for(int i = a.length(); i >= 0; i--) {
            for(int j = b.length(); j >= 0; j--) {
                // if match
                if(a.charAt(i) == b.charAt(j))
                    // tabulation step 3 (add dp in the recursive call)
                    ans = 1 + dp[i + 1][ j + 1];

                    // if not match
                else
                    // max of recursive call for i+1, j and recursive call for i, j+1
                    // memoization step 3 (add dp in the recursive call)
                    ans = Math.max(dp[i + 1][ j],dp[i][j + 1]);

                // memoization step 5 ( store the ans in dp and then return the ans from dp)
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }

    private static int solveTabSo(String a, String b) {
        // tabulation step 1 - create dp array
        int[] curr = new int[b.length() + 1];
        int[] next = new int[a.length() + 1];

        int ans = 0;

        for(int i = a.length(); i >= 0; i--) {
            for(int j = b.length(); j >= 0; j--) {
                // if match
                if(a.charAt(i) == b.charAt(j))
                    // tabulation step 3 (add dp in the recursive call)
                    ans = 1 + next[ j + 1];

                    // if not match
                else
                    // max of recursive call for i+1, j and recursive call for i, j+1
                    // memoization step 3 (add dp in the recursive call)
                    ans = Math.max(next[ j], curr[j + 1]);

                // memoization step 5 ( store the ans in dp and then return the ans from dp)
                curr[j] = ans;
            }
            next = curr;
        }
        return curr[0];
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        System.out.println(longestCommonSubsequence(s1, s2));
    }
}