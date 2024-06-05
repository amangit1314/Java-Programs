package arrays;
import java.util.*;

//Java Program for First Repeating Element
public class FRE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of elements in the array
        System.out.print("Enter the number of elements: ");
        int numberOfElements = scanner.nextInt();

        // Create an array to store the input elements
        int[] inputArray = new int[numberOfElements];

        // Get the input elements from the user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < numberOfElements; i++) {
            inputArray[i] = scanner.nextInt();
        }

        // Create an array to store indices of first occurrences (large enough to avoid overflow)
        int[] firstOccurrenceIndices = new int[1000002]; // Can be adjusted based on expected input range

        // Initialize all indices to -1 (not seen)
        for (int i = 0; i < firstOccurrenceIndices.length; i++) {
            firstOccurrenceIndices[i] = -1;
        }

        // Find the first repeating element and its index
        int minIndex = Integer.MAX_VALUE; // Initialize with largest possible value
        for (int i = 0; i < numberOfElements; i++) {
            int element = inputArray[i];

            // If the element has already been seen, update the minimum index
            if (firstOccurrenceIndices[element] != -1) {
                minIndex = Math.min(minIndex, firstOccurrenceIndices[element]);
            } else {
                // Store the current index as the first occurrence of this element
                firstOccurrenceIndices[element] = i;
            }
        }

        // Print the result
        if (minIndex == Integer.MAX_VALUE) {
            System.out.println("No repeating element found");
        } else {
            System.out.println("First repeating element index: " + (minIndex + 1));
        }

        scanner.close(); // Close the scanner resource
    }
}