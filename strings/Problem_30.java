package strings;

// Minimum number of swaps for bracket balancing.
public class Problem_30 {
    public static int minSwaps(String str) {
        int countOpen = 0;
        int countClose = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '[') {
                countOpen++;
            } else if (ch == ']') {
                if (countOpen > 0) {
                    countOpen--; // Balanced an opening bracket
                } else {
                    countClose++; // Extra closing bracket
                }
            }
        }

        return countOpen + countClose; // Minimum number of swaps
    }

    public static void main(String[] args) {
        String str = "]]][[[[";
        int minSwaps = minSwaps(str);
        System.out.println("Minimum swaps required for balancing: " + minSwaps);
    }
}
