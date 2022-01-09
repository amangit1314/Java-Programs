package strings;
import java.util.*;
// Problem Title => EDIT Distance [Very Imp]
public class Problem_14 {

    static int min(int x, int y, int z){
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    static int editDistance(String str1, String str2, int m, int n){
        if(m == 0)  return n;
        if(n == 0)  return n;
        if(str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDistance(str1, str2, m - 1, n - 1);

        return 1
                + min(editDistance(str1, str2, m, n - 1), // Insert
                editDistance(str1, str2, m - 1, n), // Remove
                editDistance(str1, str2, m - 1, n - 1) // Replace
        );

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(editDistance(str1, str2, str1.length(), str2.length()));
    }
}