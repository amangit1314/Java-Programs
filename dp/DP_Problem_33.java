// Count number of ways to reacha given score in a game

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_33 {
    public static int countWaysToReachScore(int score, int[] points) {
        int[] dp = new int[score + 1];
        dp[0] = 1; // One way to reach score 0

        for (int i = 1; i <= score; i++) {
            for (int point : points) {
                if (i - point >= 0) {
                    dp[i] += dp[i - point];
                }
            }
        }

        return dp[score];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target score: ");
        int score = scanner.nextInt();
        System.out.print("Enter number of different scoring options: ");
        int n = scanner.nextInt();
        int[] points = new int[n];

        System.out.println("Enter the scoring options:");
        for (int i = 0; i < n; i++) {
            points[i] = scanner.nextInt();
        }

        int result = countWaysToReachScore(score, points);
        System.out.println("Number of ways to reach the score " + score + " is: " + result);
    }
}
       