package strings;

public class Problem_35 {

    public static int minChars(String str) {
        int n = str.length();

        // Create a table to store longest palindrome ending at each index (LCP)
        int[][] lcp = new int[n][n];

        // Calculate length of longest common prefix (LCP) for all substrings
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    lcp[i][j] = (i + 1 == j) ? 1 : 1 + lcp[i + 1][j - 1];
                } else {
                    lcp[i][j] = 0;
                }
            }
        }

        // Minimum characters to add is the length of the string minus the length of the
        // longest suffix palindrome
        int longestSuffixPalindrome = lcp[0][n - 1];
        return n - longestSuffixPalindrome;
    }

    public static void main(String[] args) {
        String str = "aacecaaa";
        int minChars = minChars(str);
        System.out.println("Minimum characters to add at front to make '" + str + "' a palindrome: " + minChars);
    }
}
