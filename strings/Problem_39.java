package strings;

// String matching where one string contains wildcard characters
public class Problem_39 {

    public static boolean isMatch(String text, String pattern) {
        int textIndex = 0;
        int patternIndex = 0;

        // Track the last matched position of '*' in the pattern
        int starIndex = -1;
        int i = 0;

        while (textIndex < text.length()) {
            char textChar = text.charAt(textIndex);
            char patternChar = pattern.charAt(patternIndex);

            // If the characters match or the pattern character is '?' (match any character)
            if (textChar == patternChar || patternChar == '?') {
                textIndex++;
                patternIndex++;
            } else if (patternChar == '*') {
                // '*' can match any sequence of characters (including empty sequence)
                starIndex = patternIndex;
                i = textIndex; // Mark the position to backtrack from if needed
                patternIndex++; // Move on in the pattern
            } else if (starIndex != -1) {
                // Mismatch after '*', try backtracking
                patternIndex = starIndex + 1; // Move to the character after '*'
                i++; // Try matching the next character in the text
                textIndex = i; // Backtrack to the position after the last match with '*'
            } else {
                // No match, return false
                return false;
            }
        }

        // Handle remaining characters in the pattern after reaching the end of the text
        while (patternIndex < pattern.length() && pattern.charAt(patternIndex) == '*') {
            patternIndex++;
        }

        return patternIndex == pattern.length(); // Return true if all characters in the pattern are matched
    }

    public static void main(String[] args) {
        String text = "baaabab";
        String pattern = "ba*a*b*ab";
        boolean isMatch = isMatch(text, pattern);
        System.out.println("Text '" + text + "' matches pattern '" + pattern + "'? " + isMatch);
    }
}
