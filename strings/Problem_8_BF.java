package strings;

import java.util.*;

//* Problem Title =>  Write a program to find the longest Palindrome in a string. [ The Longest palindromic Substring ]

public class Problem_8_BF {
    // Function to print a substring
    static void printSubString(String inputString, int low, int high) {
        for (int i = low; i <= high; ++i) {
            System.out.print(inputString.charAt(i));
        }
    }

    // This function prints the longest palindrome substring in a string.
    // It also returns the length of the longest palindrome
    static int findLongestPalindromicSubString(String inputString) {

        // Get length of the input string
        int stringLength = inputString.length();

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        int startIndex = 0;

        // Nested loop to find starting and ending indexes of the longest palindrome
        for (int i = 0; i < stringLength; i++) {
            for (int j = i; j < stringLength; j++) {
                boolean isPalindrome = true;

                // Check if the substring is a palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++) {
                    if (inputString.charAt(i + k) != inputString.charAt(j - k)) {
                        isPalindrome = false;
                        break;
                    }
                }

                // If a palindrome is found and its length is greater than the current maximum
                if (isPalindrome && (j - i + 1) > maxLength) {
                    startIndex = i;
                    maxLength = j - i + 1;
                }
            }
        }

        System.out.println("Longest palindrome substring is: ");
        printSubString(inputString, startIndex, startIndex + maxLength - 1);

        // Return length of the longest palindrome substring
        return maxLength;
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input string: ");

        String inputString = scanner.nextLine();
        System.out.println(
                "Length of the longest palindrome substring is: " + findLongestPalindromicSubString(inputString));
        scanner.close();
    }
}