package strings;

import java.util.Scanner;

// Check whether a string is palindrome or not
public class Palindrome {
    static boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sx = new Scanner(System.in);
        String s = sx.nextLine();
        if (isPalindrome(s))
            System.out.print("Yes");
        else
            System.out.print("No");

    }
}