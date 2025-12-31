package dp;

// Problem Title => Palindrome Partitioning Problem

public class DP_Problem_51 {
    // Function to check if a string is palindrome
    static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Function to find the minimum number of cuts needed for palindrome partitioning
    static int minCuts(String str) {
        int n = str.length();
        int[] cuts = new int[n];

        for (int i = 0; i < n; i++) {
            if (isPalindrome(str, 0, i)) {
                cuts[i] = 0;
            } else {
                cuts[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome(str, j + 1, i) && cuts[j] + 1 < cuts[i]) {
                        cuts[i] = cuts[j] + 1;
                    }
                }
            }
        }
        return cuts[n - 1];
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println("Minimum cuts needed for Palindrome Partitioning is: " + minCuts(str));
    }
}