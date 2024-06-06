package stack_and_queue;

import java.util.Queue;
import java.util.*;
// Queue based approach or first non-repeating character in a stream

public class P37 {
    public String FirstNonRepeating(String A) {
        String ans = "" + A.charAt(0);
        Queue<Character> q = new LinkedList<>();
        q.add(A.charAt(0));
        int arr[] = new int[26];
        arr[ans.charAt(ans.length() - 1) - 'a']++;

        for (int i = 1; i < A.length(); i++) {

            arr[A.charAt(i) - 'a']++;
            if (arr[A.charAt(i) - 'a'] == 1) {
                q.add(A.charAt(i));
            }
            if (ans.charAt(ans.length() - 1) == A.charAt(i)) {

                while (arr[q.peek() - 'a'] > 1) {

                    q.remove();
                    if (q.peek() == null) {
                        break;
                    }
                }

                if (q.peek() == null) {
                    ans = ans + '#';
                } else {
                    ans = ans + q.peek();
                }

            } else {
                if (q.peek() == null) {
                    ans = ans + '#';
                } else {
                    ans = ans + q.peek();
                }

            }

        }
        return ans;
    }
}