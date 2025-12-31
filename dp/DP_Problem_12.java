package dp;

// Problem: Painting the fence
public class DP_Problem_12 {

    public static int countWays(int n, int k) {
        // Handle invalid cases (non-positive values)
        if (n <= 0 || k <= 0) {
            return 0;
        }

        // Initialize DP tables to store possible painting combinations
        int[][] dp = new int[n + 1][k + 1];

        // Base case: 1 post can be painted in k ways
        for (int color = 1; color <= k; color++) {
            dp[1][color] = k;
        }

        // Fill the DP table iteratively
        for (int posts = 2; posts <= n; posts++) {
            for (int color = 1; color <= k; color++) {
                // Total ways for current post:
                // - Ways to paint it differently from the previous post (sum of previous row)
                // - Ways to paint it the same as the previous post (all colors except the
                // current one)
                dp[posts][color] = (sum(dp[posts - 1]) - dp[posts - 1][color] + k) % 1000000007;
            }
        }

        // Return the sum of last row (total ways to paint n posts)
        return sum(dp[n]);
    }

    private static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total = (total + num) % 1000000007;
        }
        return total;
    }

    public static void main(String[] args) {
        int numPosts = 3;
        int numColors = 2;

        int totalWays = countWays(numPosts, numColors);
        System.out.println("Total ways to paint " + numPosts + " posts with " + numColors + " colors: " + totalWays);
    }

}
