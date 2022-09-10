package searchingSortingProblems;

import java.util.Scanner;

// Problem Title => Search in a rotated sorted arrays.array
public class SSP_Problem_03 {

    public static String countAndSay(int n){
        if(n == 1) return "1";
        if(n == 2) return "11";

        StringBuilder str = new StringBuilder("11");
        for(int i = 3; i <= n; i++){
            str.append('$');
            int len = str.length();
            int cnt = 1;
            StringBuilder temp = new StringBuilder();
            char[] a = str.toString().toCharArray();
            for (int j = 1; j < len; j++)
            {
                // If current character
                // does't match
                if (a[j] != a[j - 1])
                {
                    // Append count of
                    // str[j-1] to temp
                    temp.append(cnt);

                    // Append str[j-1]
                    temp.append(a[j - 1]);

                    // Reset count
                    cnt = 1;
                }

                // If matches, then increment
                // count of matching characters
                else cnt++;
            }

            // Update str
            str = new StringBuilder(temp.toString());
        }

        return str.toString();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int N = 3;
        System.out.println(countAndSay(N));
    }
}