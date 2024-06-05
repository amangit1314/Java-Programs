package strings;
// Blanaced

import java.util.Stack;

public class Problem_16 {

    public static boolean isBalanced(String expression) {
        if (expression == null || expression.isEmpty()) {
            return true; // Empty string is considered balanced
        }

        Stack<Character> openingBrackets = new Stack<>();
        char[] chars = expression.toCharArray();

        for (char c : chars) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    openingBrackets.push(c); // Push opening brackets to the stack
                    break;
                case '}':
                    if (openingBrackets.isEmpty() || openingBrackets.pop() != '{') {
                        return false; // Mismatched closing bracket
                    }
                    break;
                case ')':
                    if (openingBrackets.isEmpty() || openingBrackets.pop() != '(') {
                        return false; // Mismatched closing bracket
                    }
                    break;
                case ']':
                    if (openingBrackets.isEmpty() || openingBrackets.pop() != '[') {
                        return false; // Mismatched closing bracket
                    }
                    break;
                default:
                    // Ignore non-bracket characters
                    break;
            }
        }

        // After iterating through all characters, check if any opening brackets remain
        // unclosed
        return openingBrackets.isEmpty();
    }

    public static void main(String[] args) {
        String expression1 = "{([])}";
        String expression2 = "[(])";

        if (isBalanced(expression1)) {
            System.out.println(expression1 + " is balanced.");
        } else {
            System.out.println(expression1 + " is not balanced.");
        }

        if (isBalanced(expression2)) {
            System.out.println(expression2 + " is balanced.");
        } else {
            System.out.println(expression2 + " is not balanced.");
        }
    }
}
