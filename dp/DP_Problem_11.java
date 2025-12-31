package dp;

// Problem Title => Assembly Line Scheduling Problem
public class DP_Problem_11 {

    public static int minTime(int[][] times, int[] exitTimes) {
        int n = times[0].length;

        // Initialize DP tables to store minimum times for each station on both lines
        int[][] dp = new int[2][n + 1];

        // Fill the exit times as base cases (no additional time needed)
        dp[0][n] = exitTimes[0];
        dp[1][n] = exitTimes[1];

        // Iterate backwards, filling DP tables in reverse order
        for (int i = n - 1; i >= 0; i--) {
            // Calculate minimum time for each line considering both options (stay or
            // switch)
            dp[0][i] = times[0][i] + Math.min(dp[0][i + 1], dp[1][i + 1] + times[1][i]);
            dp[1][i] = times[1][i] + Math.min(dp[1][i + 1], dp[0][i + 1] + times[0][i]);
        }

        // Return the minimum time starting from either line (0 or 1)
        return Math.min(dp[0][0], dp[1][0]);
    }

    public static void main(String[] args) {
        int[][] times = { { 7, 9, 3, 4, 8, 4 }, { 8, 5, 6, 4, 5, 7 } };
        int[] exitTimes = { 4, 2 };

        int minTotalTime = minTime(times, exitTimes);
        System.out.println("Minimum time to complete assembly: " + minTotalTime);

    }

}