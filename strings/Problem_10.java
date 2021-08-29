package strings;
import java.util.*;

// Problem Title => Print all subsequences of a String

public class Problem_10 {

    // str : Stores input string
    // n : Length of str.
    // curr : Stores current permutation
    // index : Index in current permutation, curr
    static void printSubSeqRec(String str, int n, int idx, String curr){
        if(idx == n)
            return;

        if(curr != null && !curr.trim().isEmpty())
            System.out.println(curr);

        for (int i = idx + 1; i < n; i++) {
            curr += str.charAt(i);
            printSubSeqRec(str, n, i, curr);

            // backtracking
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    // Generates power set in lexicographic order.
    static void printSubSeq(String str){
        int index = -1;
        String curr = "";
        printSubSeqRec(str, str.length(), index, curr);
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printSubSeq(str);
    }
}