package recursion;
import java.util.*;
/**
 * Problem - Find K-th Permutation Sequence
 * Given - Given N and K, where N is the sequence of numbers from 1 to N([1,2,3….. N])
 * Task - find the Kth permutation sequence.
 *
 * For N = 3  the 3!  Permutation sequences in order would look like this:-
 * Note: 1 <= K <= N! Hence for a given input its Kth permutation always exists
 *
 * Examples:
 *
 *      Example 1:
 *          Input: N = 3, K = 3
 *          Output: “213”
 *          Explanation:
 *              The sequence has 3! permutations as illustrated in the figure above.
 *              K = 3 corresponds to the third sequence.
 *
 *      Example 2:
 *          Input: N = 3, K = 5
 *          Result: “312”
 *          Explanation:
 *              The sequence has 3! permutations as illustrated in the figure above.
 *              K = 5 corresponds to the fifth sequence.
 */

public class KthPermutationSequence {

    // Brute Force
    static void swap(char[] s, int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }

    static void permutationHelper(char[] s, int index, ArrayList < String > res) {
        if (index == s.length) {
            String str = new String(s);
            res.add(str);
            return;
        }

        for (int i = index; i < s.length; i++) {
            swap(s, i, index);
            permutationHelper(s, index + 1, res);
            swap(s, i, index);
        }
    }

    // Time Complexity: O(N! * N) +O(N! Log N!)
    // Space : O(N)
    static String getPermutationBruteForce(int n, int k) {
        StringBuilder s = new StringBuilder();
        ArrayList < String > res = new ArrayList < > ();
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }
        permutationHelper(s.toString().toCharArray(), 0, res);
        Collections.sort(res);

        return res.get(k);
    }

    // Time Complexity - O(N) * O(N) = O(N^2)
    // Reason: We are placing N numbers in N positions.
    // This will take O(N) time.
    // For every number, we are reducing the search space by removing the element already placed in the previous step.
    // This takes another O(N) time.
    // Space Complexity - O(N
    static String getPermutationOptimal(int n, int k) {
        int fact = 1;
        ArrayList < Integer > numbers = new ArrayList < > ();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k - 1;
        while (true) {
            ans = ans + "" + numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3, k = 3;
        String ans2 = getPermutationBruteForce(n, k);
        String ans = getPermutationOptimal(n, k);
        System.out.println("The Kth permutation sequence is from BF " + ans2);
        System.out.println("The Kth permutation sequence is " + ans);
    }
}