// Max Length Chain of Pairs
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class DP_Problem_24 {
    public static int maxChainLength(Pair[] pairs) {
        int n = pairs.length;

        // Sort pairs based on the second element
        Arrays.sort(pairs, Comparator.comparingInt(a -> a.second));

        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Each pair can form a chain of length 1

        // Build the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i].first > pairs[j].second && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // Find the maximum length from the dp array
        int maxLength = 0;
        for (int length : dp) {
            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of pairs: ");
        int n = scanner.nextInt();
        Pair[] pairs = new Pair[n];

        System.out.println("Enter the pairs (first second):");
        for (int i = 0; i < n; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            pairs[i] = new Pair(first, second);
        }

        int result = maxChainLength(pairs);
        System.out.println("Maximum length of chain is: " + result);
    }
}
