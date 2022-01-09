package strings;
import java.util.*;

// Problem Title => Split the Binary string into two substring with equal 0’s and 1’s

public class Problem_12 {

    // Function to return the count of maximum substrings str can be divided into
    static int maxSubStr(String str, int n){
        // To store the count of 0s and 1s
        int count0 = 0, count1 = 0;

        // To store the count of maximum substrings str can be divided into
        int cnt = 0;
        for (int i = 0; i < n; i++){
            if(str.charAt(i) == 0)
                count0++;
            else
                count1++;
            if(count0 == count1)
                cnt++;
        }
        // it is not possible to split the string
        if(cnt == 0)
            return -1;
        return cnt;
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();

        System.out.println(maxSubStr(str,n));
    }
}

// Time Complexity => O(n) {Linear}
// Space Complexity => O(1) {constant}