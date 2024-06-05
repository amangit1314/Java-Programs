package strings;

//* Boyer Moore Algorithm for Pattern Searching.
public class Problem_25 {
    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Preprocessing: create bad character table
        int[] badCharTable = buildBadCharTable(pattern);

        int shift = m - 1; // Initial shift

        while (shift <= n - m) {
            int j = m - 1; // Index for pattern

            while (j >= 0 && text.charAt(shift + j) == pattern.charAt(j)) {
                j--; // Characters match, move to previous character
            }

            if (j == -1) { // Pattern found
                return shift;
            }

            // Mismatch occurred, use bad character table
            shift += Math.max(badCharTable[text.charAt(shift + j)] - j, 1);
        }

        return -1; // Pattern not found
    }

    private static int[] buildBadCharTable(String pattern) {
        int[] badCharTable = new int[256]; // Assuming ASCII characters

        // Fill the table with the maximum distance between the current character
        // and its rightmost occurrence in the pattern (except the last character)
        for (int i = 0; i < pattern.length() - 1; i++) {
            badCharTable[pattern.charAt(i)] = pattern.length() - 1 - i;
        }

        // The last character of the pattern always gets a shift of 1
        badCharTable[pattern.charAt(pattern.length() - 1)] = 1;

        return badCharTable;
    }

    public static void main(String[] args) {
        String text = "THIS IS A TEXT BOOK EXAMPLE";
        String pattern = "EXAMPLE";

        int index = search(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}