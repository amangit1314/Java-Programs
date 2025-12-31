// Min Cost Path Problem

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_27 {
    public static int minCostPath(int[][] cost, int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = cost[0][0];

        // Initialize first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }

        // Initialize first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + cost[0][j];
        }

        // Fill the rest of the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = cost[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int m = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int n = scanner.nextInt();
        int[][] cost = new int[m][n];

        System.out.println("Enter the cost matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }

        int result = minCostPath(cost, m, n);
        System.out.println("Minimum cost to reach the bottom-right corner is: " + result);
    }
}
