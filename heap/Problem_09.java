package heap;
import java.util.*;

/* <------------------------------------------------------------------------------------------------------------------->
    Given -> A string s, rearrange the characters of s so that any two adjacent characters are not the same.
    <------------------------------------------------------------------------------------------------------------------>
    Task  -> Return any possible rearrangement of s or return "" if not possible.
    <------------------------------------------------------------------------------------------------------------------>
    Example 1:
    <------------------------------------------------------------------------------------------------------------------>
    Input: s = "aab"
    Output: "aba"
    <------------------------------------------------------------------------------------------------------------------>
    Example 2:
    <------------------------------------------------------------------------------------------------------------------>
    Input: s = "aaab"
    Output: ""
    <------------------------------------------------------------------------------------------------------------------>
    Constraints:
        1 <= s.length <= 500
        s consists of lowercase English letters.
    <------------------------------------------------------------------------------------------------------------------>
*/

public class Problem_09 {

    public String reorganizeString(String s) {
        int n = s.length();

        if (n < 2)
            return s;

        int[] counts = new int[26];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int pos = s.charAt(i) - 'a';
            counts[pos]++;
            max = Math.max(max, counts[pos]);
        }

        if (max > (n + 1) / 2)
            return "";

        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> counts[c2 - 'a'] - counts[c1 - 'a']);

        for (char c = 'a'; c <= 'z'; c++)
            if (counts[c - 'a'] > 0)
                pq.offer(c);

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            char c1 = pq.poll();
            char c2 = pq.poll();

            sb.append(c1);
            sb.append(c2);

            int index1 = c1 - 'a';
            int index2 = c2 - 'a';

            counts[index1]--;
            counts[index2]--;

            if (counts[index1] > 0)
                pq.offer(c1);

            if (counts[index2] > 0)
                pq.offer(c2);
        }

        if (pq.size() > 0)
            sb.append(pq.poll());

        return sb.toString();
    }
    public static void main(String[] args) {

    }
}