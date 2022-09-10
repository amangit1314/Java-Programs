package stack_and_queue.practice;
import java.util.*;

public class CheckBalancedParanthesis {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if(st.isEmpty())
                    return false;
                char ch = st.pop();
                if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{'))
                    continue;
                else
                    return false;
            }
        }
        return st.isEmpty();
    }

    public static void main (String[] args) {

        String s = "()[{}()]";
        if(!isValid(s))
            System.out.println("True");

        else
            System.out.println("False");
    }
}