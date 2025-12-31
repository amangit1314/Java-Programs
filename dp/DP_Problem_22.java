package dp;

// Problem: 

// Given an array arr containing positive integers. Find the maximum sum that can be formed which has no three consecutive elements present from the array.

// Examples:

// Input: arr[] = [1, 2, 3]
// Output: 5
// Explanation: All three element present in the array is consecutive, hence we have to consider just two element sum having maximum,which is 2+3 = 5
// Input: arr[] = [3000, 2000, 1000, 3, 10]
// Output: 5013
// Explanation: 3000 + 2000 + 3 + 10 = 5013. Here no three elements is consecutive in that subsequence.

public class DP_Problem_22 {
    public static int maxSumNoThreeConsec(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return arr[0] + arr[1];

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3000, 2000, 1000, 3, 10};
        int result = maxSumNoThreeConsec(arr);
        System.out.println("Maximum sum with no three consecutive elements: " + result);
    }
}
