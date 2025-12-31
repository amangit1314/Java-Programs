package dp;

import java.util.Arrays;

// Longest increasing subsequence
public class DP_Problem_16 {
    public int lengthOfLongestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]); // Update max with the current largest LIS length
        }

        return max;
    }

}
