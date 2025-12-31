// Max difference of zeros and ones in binary string

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_28 {
    public static int maxDiffZerosOnes(String str) {
        int n = str.length();
        int[] dp = new int[n];
        dp[0] = (str.charAt(0) == '0') ? 1 : -1;
        int maxDiff = dp[0];

        for (int i = 1; i < n; i++) {
            int value = (str.charAt(i) == '0') ? 1 : -1;
            dp[i] = Math.max(value, dp[i - 1] + value);
            maxDiff = Math.max(maxDiff, dp[i]);
        }

        return Math.max(0, maxDiff); // Return 0 if all characters are '1'
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String str = scanner.nextLine();

        int result = maxDiffZerosOnes(str);
        System.out.println("Maximum difference of zeros and ones is: " + result);
    }
}
