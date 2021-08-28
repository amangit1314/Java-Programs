package strings;
import java.util.*;

// Problem Title =>  Write a program to find the longest Palindrome in a string. [ The Longest palindromic Substring ]

public class Problem_8_BF {

    // function to print a substring
    static void printSubString(String str, int low, int high){
        for(int i = low; i <= high; ++i)
            System.out.print(str.charAt(i));
    }

    // This function prints the longest palindrome substring.
    // It also returns the length of the longest palindrome
    static int longestPalSubString(String str){

        // get length of input string
        int n = str.length();

        // All subStrings of length 1 are palindrome
        int maxLength = 1, start = 0;

        // Nested loop to mark start and end index
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int flag = 1;

                //check palindrome
                for(int k = 0; k <(j - i + 1)/2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k)) {
                        flag = 0;
                        break;
                    }

                // palindrome
                if(flag != 0 && (j - i + 1) > maxLength){
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        System.out.println("Longest palindrome subString is : ");
        printSubString(str, start, start + maxLength - 1);

        // return length of LPS
        return maxLength;
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string : ");

        String str = sc.nextLine();
        System.out.println("Length is : " + longestPalSubString(str));
    }
}