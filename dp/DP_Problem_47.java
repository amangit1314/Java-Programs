// Count Dearrangements (Permutation such that no element appears in its original position)

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_47 {
    static int countDerangements(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: !0 = 1
        if (n > 0) {
            dp[1] = 0; // Base case: !1 = 0
        }
        if (n > 1) {
            dp[2] = 1; // Base case: !2 = 1
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("Number of derangements for " + n + " elements is: " + countDerangements(n));
        sc.close();
    }
}
       