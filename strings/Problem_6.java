package strings;

import java.util.Scanner;

public class Problem_6 {
    static boolean compare(int []arr1, int []arr2) {
        for(int i = 0; i < 256; i++)
            if (arr1[i] != arr2[i])
                return false;

        return true;
    }

    // This function search for all
    // permutations of pat[] in txt[]
    static boolean search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // countP[]: Store count of all
        // characters of pattern
        // countTW[]: Store count of
        // current window of text
        int []countP = new int [256];
        int []countTW = new int [256];
        for(int i = 0; i < 256; i++)
        {
            countP[i] = 0;
            countTW[i] = 0;
        }

        for(int i = 0; i < M; i++) {
            (countP[pat.charAt(i)])++;
            (countTW[txt.charAt(i)])++;
        }

        // Traverse through remaining
        // characters of pattern
        for(int i = M; i < N; i++) {

            // Compare counts of current
            // window of text with
            // counts of pattern[]
            if (compare(countP, countTW))
                return true;

            // Add current character to
            // current window
            (countTW[txt.charAt(i)])++;

            // Remove the first character
            // of previous window
            countTW[txt.charAt(i - M)]--;
        }

        // Check for the last window in text
        return compare(countP, countTW);
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        String pat = sc.nextLine();

        if (search(pat, txt))
            System.out.println("Yes");
        else
            System.out.println("NO");
    }
}