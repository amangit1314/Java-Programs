package strings;

import java.util.Scanner;

public class Problem_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to reverse: ");
        String inputString = scanner.nextLine();

        System.out.println("Choose reversal method (1 or 2):");
        System.out.println("1. Using StringBuffer");
        System.out.println("2. In-place character swapping");

        int choice = scanner.nextInt();

        String reversedString;
        if (choice == 1) {
            reversedString = reverseUsingStringBuilder(inputString);
        } else if (choice == 2) {
            reversedString = reverseUsingCharacterSwapping(inputString);
        } else {
            System.out.println("Invalid choice. Using default (StringBuffer)");
            reversedString = reverseUsingStringBuilder(inputString);
        }

        System.out.println("Reversed String: " + reversedString);

        scanner.close();
    }

    public static String reverseUsingStringBuilder(String inputString) {
        StringBuilder stringBuilder = new StringBuilder(inputString);
        return stringBuilder.reverse().toString();
    }

    /**
     * Reverses the string in-place by swapping characters from start and end.
     * (This approach avoids creating a new String object)
     */
    public static String reverseUsingCharacterSwapping(String inputString) {
        int startIndex = 0;
        int endIndex = inputString.length() - 1;

        char[] charArray = inputString.toCharArray();
        while (startIndex < endIndex) {
            char temp = charArray[startIndex];
            charArray[startIndex] = charArray[endIndex];
            charArray[endIndex] = temp;

            startIndex++;
            endIndex--;
        }

        return String.valueOf(charArray); // Convert char array back to String
    }
}
