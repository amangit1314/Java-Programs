package strings;

//  Number of flips to make binary string alternate
public class Problem_28 {
    public static int minFlips(String A) {
        int flipTo0 = 0, flipTo1 = 0;

        // Iterate through the string
        for (int i = 0; i < A.length(); i++) {
            char expected = (i % 2 == 0) ? '0' : '1'; // Expected character based on even/odd position

            // Count flips if the current character is different from expected
            if (A.charAt(i) != expected) {
                if (expected == '0') {
                    flipTo0++;
                } else {
                    flipTo1++;
                }
            }
        }

        // Return the minimum number of flips
        return Math.min(flipTo0, flipTo1);
    }

    public static void main(String[] args) {
        String A = "001";
        int minFlips = minFlips(A);
        System.out.println("Minimum number of flips for " + A + ": " + minFlips);
    }
}
