/*
 * Write a program to cyclically rotate an arrays.array by one.
 */

package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Array_Problem_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the array from the user
        System.out.print("Enter the size of the array: ");
        int arraySize = scanner.nextInt();

        // Create an array to store the input elements
        int[] inputArray = new int[arraySize];

        // Get the elements of the array from the user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = scanner.nextInt();
        }

        // Print the original array
        System.out.println("Original array:");
        System.out.println(Arrays.toString(inputArray));

        // Perform the cyclic rotation
        rotateArray(inputArray);

        // Print the rotated array
        System.out.println("Rotated array:");
        System.out.println(Arrays.toString(inputArray));

        scanner.close(); // Close the scanner resource
    }

    // Function to cyclically rotate an array by one element
    public static void rotateArray(int[] array) {
        if (array.length == 0) {
            return; // Handle empty array case
        }

        // Store the last element of the array
        int lastElement = array[array.length - 1];

        // Shift elements one position to the right
        for (int i = array.length - 2; i >= 0; i--) {
            array[i + 1] = array[i];
        }

        // Place the last element at the beginning
        array[0] = lastElement;
    }
}
