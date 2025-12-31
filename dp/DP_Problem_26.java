// Maximum sum of pairs with specific difference

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_26 {
    public static int maxSumPairsWithDiffK(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            if (arr[i] - arr[i - 1] == k) {
                int sumWithPair = arr[i] + arr[i - 1];
                if (i >= 2) {
                    sumWithPair += dp[i - 2];
                }
                dp[i] = Math.max(dp[i], sumWithPair);
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the difference k: ");
        int k = scanner.nextInt();

        int result = maxSumPairsWithDiffK(arr, n, k);
        System.out.println("Maximum sum of pairs with difference " + k + " is: " + result);
    }
}
