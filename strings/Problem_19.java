package strings;

//* KMP algo
public class Problem_19 {

    public static void search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Preprocess the pattern to compute the longest prefix-suffix (LPS) array
        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                // Pattern found at index i - j
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1]; // Shift the pattern using LPS
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                // Mismatch occurred, use LPS
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // length of the previous longest prefix suffix

        lps[0] = 0; // lps[0] is always 0

        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // mismatch occurred, check previous prefix if any
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    // No prefix found, set lps[i] to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        search(text, pattern);
    }
}
