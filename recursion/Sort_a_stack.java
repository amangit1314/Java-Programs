package recursion;
import java.util.*;

public class Sort_a_stack {

    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()) {
            return s;
        }

        int temp = s.pop();
        sort(s);
        helper(s, temp);
        return s;
    }

    void helper(Stack<Integer> s, int temp) {
        if(s.isEmpty() || temp > s.peek()) {
            s.push(temp);
            return;
        }

        int element= s.pop();
        helper(s, temp);
        s.push(element);
    }

    public static void main(String[] args) {

    }
}