package strings;

// Recursively remove all adjacent duplicates
public class Problem_38 {
    public static String removeDuplicates(String str) {
        if (str == null || str.length() <= 1) {
            return str; // Empty or single-character string has no duplicates to remove
        }

        // Check if the first two characters are duplicates
        if (str.charAt(0) == str.charAt(1)) {
            // Remove the first character and recursively call the function on the remaining
            // string
            return removeDuplicates(str.substring(1));
        } else {
            // If first two characters are different, prepend the first character to the
            // result of the recursive call on the remaining string
            return str.charAt(0) + removeDuplicates(str.substring(1));
        }
    }

    public static void main(String[] args) {
        String str = "AABBCCCD";
        String result = removeDuplicates(str);
        System.out.println("String after removing adjacent duplicates: " + result);
    }
}
