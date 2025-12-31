// Partition Problem

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            totalSum += arr[i];
        }

        if (totalSum % 2 != 0) {
            System.out.println("Not Possible");
            return;
        }

        int target = totalSum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        if (dp[n][target]) {
            System.out.println("Possible");
        } else {
            System.out.println("Not Possible");
        }
    }
}
       