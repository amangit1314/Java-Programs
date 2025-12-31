// Largest Independent Set Problem

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_39 {
    public static int largestIndependentSet(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = Math.max(arr[0], arr[1]);


        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = largestIndependentSet(arr);
        System.out.println("The size of the largest independent set is: " + result);
    }
}
       