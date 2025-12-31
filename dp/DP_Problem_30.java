// Min cost to fill given weight in a bag

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_30 {
    public static int minCostToFillWeight(int[] weights, int[] costs, int n, int W) {
        int[] dp = new int[W + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int w = 1; w <= W; w++) {
            for (int i = 0; i < n; i++) {
                if (weights[i] <= w && dp[w - weights[i]] != Integer.MAX_VALUE) {
                    dp[w] = Math.min(dp[w], dp[w - weights[i]] + costs[i]);
                }
            }
        }

        return (dp[W] == Integer.MAX_VALUE) ? -1 : dp[W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();
        int[] weights = new int[n];
        int[] costs = new int[n];

        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.println("Enter the costs of the items:");
        for (int i = 0; i < n; i++) {
            costs[i] = scanner.nextInt();
        }

        System.out.print("Enter the total weight W to fill: ");
        int W = scanner.nextInt();

        int result = minCostToFillWeight(weights, costs, n, W);
        if (result != -1) {
            System.out.println("Minimum cost to fill weight " + W + " is: " + result);
        } else {
            System.out.println("It's not possible to fill the weight " + W + " with given items.");
        }
    }
}
