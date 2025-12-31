// Optimal Strategy for a Game

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_49 {
    static int optimalGameStrategy(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                int x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(values[i] + Math.min(x, y), values[j] + Math.min(y, z));
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] values = new int[n];
        System.out.println("Enter the values:");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        System.out.println("Maximum profit the first player can get: " + optimalGameStrategy(values));
        sc.close();
    }
}