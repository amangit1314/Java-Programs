package strings;

// Transform One String to Another using Minimum Number of Given Operation
public class Problem_41 {
    public static int minOperations(String A, String B, char replaceChar) {
        if (A == null || B == null || A.length() != B.length()) {
            return -1; // Invalid input (strings must be of the same length)
        }

        int operations = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                operations++; // Increment for each character that needs replacement
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        String A = "APPLE";
        String B = "APPLES";
        char replaceChar = 'S';
        int minOps = minOperations(A, B, replaceChar);
        System.out.println("Minimum operations to transform '" + A + "' to '" + B + "' (replace with '" + replaceChar
                + "'): " + minOps);
    }
}
