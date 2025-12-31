// Longest Alternating SubString

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_44 {
    static int longestAlternatingSubstr(String str) {
        int n = str.length();
        if (n == 0) return 0;

        int maxLength = 1;
        int currLength = 1;

        for (int i = 1; i < n; i++) {
            if ((str.charAt(i) > str.charAt(i - 1) && (i % 2 == 1)) ||
                (str.charAt(i) < str.charAt(i - 1) && (i % 2 == 0))) {
                currLength++;
            } else {
                maxLength = Math.max(maxLength, currLength);
                currLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currLength);
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Length of Longest Alternating Substring is: " + longestAlternatingSubstr(str));
        sc.close();
    }
}
       