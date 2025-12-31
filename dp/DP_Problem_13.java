package dp;

// PROBLEM: Maximize Cut Segments
public class DP_Problem_13 {
    public static int maximizeCuts(int n, int x, int y, int z) {
        // Array to store maximum cuts for lengths up to n
        int[] dp = new int[n + 1];

        // Initialize base cases
        dp[0] = 0; // Rod of length 0 has 0 cuts

        // Fill the DP table iteratively
        for (int i = 1; i <= n; i++) {
            int maxCuts = 0;

            // Check if cuts with lengths x, y, or z are possible and beneficial
            if (i >= x) {
                maxCuts = Math.max(maxCuts, dp[i - x] + 1); // Take the best from previous cuts + 1 for current cut
            }
            if (i >= y) {
                maxCuts = Math.max(maxCuts, dp[i - y] + 1);
            }
            if (i >= z) {
                maxCuts = Math.max(maxCuts, dp[i - z] + 1);
            }

            // Store the maximum number of cuts for the current length
            dp[i] = maxCuts;
        }

        return dp[n]; // Return the maximum number of cuts for the given rod length
    }

    public static void main(String[] args) {
        int rodLength = 5;
        int cutLengthX = 2;
        int cutLengthY = 5;
        int cutLengthZ = 1;

        int maxCuts = maximizeCuts(rodLength, cutLengthX, cutLengthY, cutLengthZ);
        System.out.println("Maximum cut segments possible: " + maxCuts);
    }
}
