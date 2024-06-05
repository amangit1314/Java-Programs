package strings;

// * Problem Title: Count and Say
public class Problem_7 {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1"; // Base case: first term is "1"
        } else if (n == 2) {
            return "11"; // Base case: second term is "11"
        }

        // Initialize result string with the base case
        String result = "11";

        // Generate terms from 3 to n based on previous terms
        for (int termNumber = 3; termNumber <= n; termNumber++) {
            StringBuilder nextTerm = new StringBuilder();

            // Process previous term character by character
            char previousChar = result.charAt(0); // Initialize with first character
            int currentCharCount = 1; // Count of consecutive occurrences of previous character

            for (int charIndex = 1; charIndex < result.length(); charIndex++) {
                char currentChar = result.charAt(charIndex);

                // If character changes, append count and character to next term
                if (currentChar != previousChar) {
                    nextTerm.append(currentCharCount);
                    nextTerm.append(previousChar);
                    previousChar = currentChar;
                    currentCharCount = 1;
                } else {
                    // If character is same, increment count
                    currentCharCount++;
                }
            }

            // Append the last character and its count (if applicable)
            nextTerm.append(currentCharCount);
            nextTerm.append(previousChar);

            // Update result string with the generated next term
            result = nextTerm.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        int n = 4;
        String sequenceTerm = countAndSay(n);
        System.out.println("Term " + n + ": " + sequenceTerm);
    }
}
