package strings;

//*  rabin karp algo
public class Problem_18 {
    public static final int d = 256; // Number of characters in the input alphabet

    public static void search(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();

        // Precompute hash value for the pattern
        int patternHash = calculateHash(pattern, patternLength);

        // Initialize a hash value for the first window of the text
        int textHash = calculateHash(text, patternLength);

        // Slide the pattern over the text
        for (int i = 0; i <= textLength - patternLength; i++) {
            // Check if current window hash matches pattern hash
            if (patternHash == textHash && checkCharacters(pattern, text, i)) {
                System.out.println("Pattern found at index " + i);
            }

            // Update hash value for the next window in the text
            if (i < textLength - patternLength) {
                textHash = recalculateHash(textHash, text.charAt(i), text.charAt(i + patternLength));
            }
        }
    }

    // Function to calculate the hash value of a string using a prime base
    private static int calculateHash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (d * hash + str.charAt(i)) % Integer.MAX_VALUE;
        }
        return hash;
    }

    // Function to recalculate the hash value for the next window in the text
    private static char recalculateHash(int oldHash, char oldChar, char newChar) {
        // Modify calculations here to ensure the result fits within char range
        // (0-65535)
        var intermediateValue = (d * (oldHash - oldChar * Math.pow(d, d - 1)) + newChar);
        return (char) (intermediateValue % Character.MAX_VALUE); // Ensure result is within char range
    }

    // Function to compare characters of pattern and text window
    private static boolean checkCharacters(String pattern, String text, int startIndex) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != text.charAt(startIndex + i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "COURSEWAVE EXAMPLE";
        String pattern = "FOR";
        search(pattern, text);
    }
}
