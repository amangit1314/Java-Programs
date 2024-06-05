package strings;

// *Find Longest Common Prefix
public class Problem_27 {

    public static String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // Empty array or null input
        }

        String prefix = strs[0]; // Initialize with the first string

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix if it's not a prefix of the current string
                prefix = prefix.substring(0, prefix.length() - 1);

                // Handle cases where there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        String lcp = findLongestCommonPrefix(strs);

        System.out.println("Longest Common Prefix for [" + String.join(", ", strs) + "] is: " + lcp);
    }
}
