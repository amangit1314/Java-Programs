package stack_and_queue;

import java.util.Stack;

// Expression Contain redundant bracket or not
public class P19 {

    static boolean checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();

        for(char ch : str) {
            if(ch == ')') {
                char top = st.peek();
                st.pop();
                boolean flag = true;
                while(top != '(') {
                    if(top == '+' || top == '-' || top == '*' || top == '/' )
                        flag = false;
                    top = st.peek();
                    st.pop();
                }

                if(flag == true)
                    return true;
            }

            else
                st.push(ch);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}