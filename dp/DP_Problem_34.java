// Count balanced binary strings of length h

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_34 {
    public static int countBalancedBinaryStrings(int h) {
        if (h == 0) return 1;
        if (h == 1) return 2;

        int[] dp = new int[h + 1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= h; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[h];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of the binary string: ");
        int h = scanner.nextInt();

        int result = countBalancedBinaryStrings(h);
        System.out.println("Number of balanced binary strings of length " + h + " is: " + result);
    }
}
       