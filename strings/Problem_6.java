package strings;

import java.util.Scanner;

// * Check whether a string is valid shuffle of two strings or not
public class Problem_6 {
    // function to compareCharacterCounts
    static boolean compareCharacterCounts(int[] charCount1, int[] charCount2) {
        for (int i = 0; i < 256; i++)
            if (charCount1[i] != charCount2[i])
                return false;

        return true;
    }

    // This function searchForPattern for all permutations of pat[] in txt[]
    static boolean searchForPattern(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();

        int[] patternCharCount = new int[256];
        int[] currentWindowCharCount = new int[256];

        for (int i = 0; i < 256; i++) {
            patternCharCount[i] = 0;
            currentWindowCharCount[i] = 0;
        }

        for (int i = 0; i < patternLength; i++) {
            (patternCharCount[pattern.charAt(i)])++;
            (currentWindowCharCount[text.charAt(i)])++;
        }

        for (int i = patternLength; i < textLength; i++) {
            if (compareCharacterCounts(patternCharCount, currentWindowCharCount))
                return true;

            (currentWindowCharCount[text.charAt(i)])++; // Add current character to current window
            currentWindowCharCount[text.charAt(i - patternLength)]--; // Remove the first character of previous window
        }

        // Check for the last window in text
        return compareCharacterCounts(patternCharCount, currentWindowCharCount);
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        String pat = sc.nextLine();

        if (searchForPattern(pat, txt))
            System.out.println("Yes");
        else
            System.out.println("NO");

        sc.close();
    }
}