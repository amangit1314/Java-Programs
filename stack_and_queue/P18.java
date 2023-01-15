package stack_and_queue;
import java.util.Stack;

// Length of the longest valid substring
public class P18 {

    public static int findMaxLen(String s) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> index = new Stack<>();

        int length, max = 0;
        index.push(-1);

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(s.charAt(i));
                index.push(i);
            }
            else {
                if(!st.isEmpty()) {
                    st.pop();
                    index.pop();
                    length = i - index.peek();

                    if(max < length)
                        max = length;
                }
                index.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}