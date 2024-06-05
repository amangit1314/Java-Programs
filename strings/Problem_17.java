package strings;

import java.util.Arrays;
import java.util.List;

//*  word break with dp
public class Problem_17 {

    public static boolean canBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] represents if the first i characters of the string can be formed using
        // words from the dictionary
        boolean[] dp = new boolean[n + 1];

        // Base case: an empty string can be formed using empty words
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                // Check if the current word is a prefix of the remaining string
                if (word.length() <= i && s.substring(0, i).equals(word)) {
                    // Inherit the state from the remaining string (i - word.length())
                    dp[i] = dp[i - word.length()];
                    if (dp[i]) { // If a solution is found, break out of the inner loop
                        break;
                    }
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        if (canBreak(s, wordDict)) {
            System.out.println(s + " can be segmented using words from the dictionary.");
        } else {
            System.out.println(s + " cannot be segmented using words from the dictionary.");
        }
    }
}
