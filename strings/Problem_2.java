package strings;

import java.util.Scanner;

//* Problem Title ==> Check String is Palindrome or not
public class Problem_2 {

    public static boolean isStringPalindrome(String inputString) {
        int startIndex = 0;
        int endIndex = inputString.length() - 1;

        // Iterate through the string while start and end haven't met
        while (startIndex < endIndex) {
            char startChar = inputString.charAt(startIndex);
            char endChar = inputString.charAt(endIndex);

            // Convert characters to lowercase for case-insensitive comparison
            startChar = Character.toLowerCase(startChar);
            endChar = Character.toLowerCase(endChar);

            // If characters are not the same (ignoring case), return false
            if (startChar != endChar) {
                return false;
            }

            startIndex++;
            endIndex--;
        }

        // If the loop completes, all characters matched (palindrome)
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        if (isStringPalindrome(inputString)) {
            System.out.println("Yes, it is a palindrome.");
        } else {
            System.out.println("No, it is not a palindrome.");
        }

        scanner.close();
    }
}