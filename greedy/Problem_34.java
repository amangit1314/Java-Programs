package greedy;

// Rearrange characters in a string such that no two adjacent are same
public class Problem_34 {
    public static String rearrangeString(String str) {
        int n = str.length();
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        int maxCount = 0;
        for (int c : count) {
            if (c > maxCount) {
                maxCount = c;
            }
        }

        if (maxCount > (n + 1) / 2) {
            return "-1"; // Not possible to rearrange
        }

        char[] result = new char[n];
        int evenIndex = 0;
        int oddIndex = 1;
        int halfLength = n / 2;

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0 && count[i] <= halfLength && oddIndex < n) {
                result[oddIndex] = (char) (i + 'a');
                count[i]--;
                oddIndex += 2;
            }
            while (count[i] > 0) {
                result[evenIndex] = (char) (i + 'a');
                count[i]--;
                evenIndex += 2;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String str = "aaabbc";
        String rearranged = rearrangeString(str);
        if (rearranged.equals("-1")) {
            System.out.println("Not possible to rearrange the string.");
        } else {
            System.out.println("Rearranged string: " + rearranged);
        }
    }
}