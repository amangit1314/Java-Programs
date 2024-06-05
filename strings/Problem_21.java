
package strings;

import java.util.Stack;

//* Minimum number of bracket reversals needed to make an expression balanced.
public class Problem_21 {

    public static int countMinReversals(String expr) {
        if (expr.length() % 2 != 0) { // Odd length expressions cannot be balanced
            return -1;
        }

        int openCount = 0;
        int closeCount = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : expr.toCharArray()) {
            if (c == '{') {
                openCount++;
                stack.push(c);
            } else if (c == '}') {
                closeCount++;
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    // Unbalanced closing bracket, need reversal
                    openCount++;
                }
            }
        }

        // Calculate remaining unbalanced brackets
        int unbalanced = Math.abs(openCount - closeCount);
        return (unbalanced + 1) / 2; // Need to reverse half of the remaining unbalanced brackets
    }

    public static void main(String[] args) {
        String expression1 = "{([)]}";
        String expression2 = "[(])";

        int reversals1 = countMinReversals(expression1);
        int reversals2 = countMinReversals(expression2);

        if (reversals1 != -1) {
            System.out.println(expression1 + " requires " + reversals1 + " reversals to be balanced.");
        } else {
            System.out.println(expression1 + " cannot be balanced.");
        }

        if (reversals2 != -1) {
            System.out.println(expression2 + " requires " + reversals2 + " reversals to be balanced.");
        } else {
            System.out.println(expression2 + " cannot be balanced.");
        }
    }
}
