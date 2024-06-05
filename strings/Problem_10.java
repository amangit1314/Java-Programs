package strings;

import java.util.*;

// Problem Title => Print all subsequences of a String

public class Problem_10 {

    // str : Stores input string
    // n : Length of str.
    // currentPermutation : Stores current Permutation
    // index : Index in current Permutation
    static void printSubSeqRec(String str, int n, int idx, String currentPermutation) {
        if (idx == n)
            return;

        if (currentPermutation != null && !currentPermutation.trim().isEmpty())
            System.out.println(currentPermutation);

        for (int i = idx + 1; i < n; i++) {
            currentPermutation += str.charAt(i);
            printSubSeqRec(str, n, i, currentPermutation);

            // backtracking
            currentPermutation = currentPermutation.substring(0, currentPermutation.length() - 1);
        }
    }

    // Generates power set in lexicographic order.
    static void printSubSeq(String str) {
        int index = -1;
        String currentPermutation = "";
        printSubSeqRec(str, str.length(), index, currentPermutation);
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printSubSeq(str);
        sc.close();
    }
}