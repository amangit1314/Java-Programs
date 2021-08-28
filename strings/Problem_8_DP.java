package strings;
import java.util.*;

// Problem Title =>  Write a program to find the longest Palindrome in a string.
// using Dynamic Programming [ The Longest palindromic Substring ]

public class Problem_8_DP {

    // utility function to print a substring
    static void printSubString(String str, int low, int high) {
        for (int i = low; i <= high; ++i)
            System.out.println(str.substring(low, high + 1));
    }

    // This function prints the longest palindrome substring.
    // It also returns the length of the longest palindrome
    static int longestPalSubString(String str) {

        // get length of input string
        int n = str.length();

        // table[i][j] will be false is substring str[i..j] is not palindrome.
        // Else table[i][j[ will be true.
        boolean[][] table = new boolean[n][n];

        // All subStrings of length 1 are palindrome
        int maxLength = 1;
        for(int i = 0; i < n; ++i)
            table[i][i] = true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2.
        // k is length of substring
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to jth index iff str.charAt(i+1) to str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {

                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is; ");
        printSubString(str, start, start + maxLength - 1);

        // return length of LPS
        return maxLength;
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string : ");

        String str = sc.nextLine();
        System.out.println("Length is : " + longestPalSubString(str));
    }
}
