package strings;

// * Find the first repeated word in string.
public class Problem_29 {

    public static String findFirstRepeatedWord(String str) {
        if (str == null || str.isEmpty()) {
            return null; // Empty string has no repeated words
        }

        int slow = 0, fast = 1;
        while (fast < str.length() && slow < str.length()) {
            if (str.charAt(slow) == str.charAt(fast)) {
                return str.substring(slow, fast + 1); // Repeated word found
            }
            slow++;
            fast += 2;
        }

        return null; // No repeated words found
    }

    public static void main(String[] args) {
        String str = "This is a string with a repeated word this";
        String firstRepeatedWord = findFirstRepeatedWord(str);

        if (firstRepeatedWord != null) {
            System.out.println("First repeated word: " + firstRepeatedWord);
        } else {
            System.out.println("No repeated words found in the string.");
        }
    }
}
