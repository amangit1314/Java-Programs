// Coin game winner where every player has three choices

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_46 {
    static int findWinner(int[] coins, int n) {
        int[][] dp = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                int x = (i + 2) <= j ? dp[i + 2][j] : 0;
                int y = (i + 1) <= (j - 1) ? dp[i + 1][j - 1] : 0;
                int z = i <= (j - 2) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(coins[i] + Math.min(x, y),
                                    coins[j] + Math.min(y, z));
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.println("Maximum amount the first player can collect is: " + findWinner(coins, n));
        sc.close();
    }
}
       