package dp;
// Problem Title => Edit Distance
/*
* Problem Statement =>
*   Given two strings str1 and str2 and below operations that can performed on str1.
*   Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
*
* Insert
* Remove
* Replace
* All the above operations are of equal cost.
* */
public class DP_Problem_07 {

    static int min(int x, int y, int z){
        if(x <= y && x <= z)
            return x;
        if(y <= x && y <= z)
            return y;
        else return z;
    }

    static int editDistanceDP(String str1, String str2, int m, int n){
        // Create a table to store results of sub-problems
        int[][] dp = new int[m + 1][n + 1];

        // Fill dp[][] in bottom up manner
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;

                else if(j == 0) dp[i][j] = i;

                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                // If the last character is different,
                // consider all possibilities and find the minimum
                else dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }

    // Driver Code
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDistanceDP(str1, str2, str1.length(), str2.length()));
    }
}

// Time Complexity: O(m x n)
// Space Taken : O(m x n)