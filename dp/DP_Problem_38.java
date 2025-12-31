// Word Break Problem

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_38 {
    public static boolean wordBreak(String s, String[] wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        System.out.print("Enter the number of words in the dictionary: ");
        int m = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] wordDict = new String[m];

        System.out.println("Enter the words in the dictionary:");
        for (int i = 0; i < m; i++) {
            wordDict[i] = scanner.nextLine();
        }

        boolean result = wordBreak(s, wordDict);
        if (result) {
            System.out.println("The string can be segmented into words from the dictionary.");
        } else {
            System.out.println("The string cannot be segmented into words from the dictionary.");
        }
    }
}
       