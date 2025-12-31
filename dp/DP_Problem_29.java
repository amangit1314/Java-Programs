// Min number of jumps to reach end

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_29 {
    public static int minJumpsToEnd(int[] arr, int n) {
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }

        return (dp[n - 1] == Integer.MAX_VALUE) ? -1 : dp[n - 1];
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

        int result = minJumpsToEnd(arr, n);
        if (result != -1) {
            System.out.println("Minimum number of jumps to reach the end is: " + result);
        } else {
            System.out.println("End is not reachable from the given array.");
        }
    }
}
