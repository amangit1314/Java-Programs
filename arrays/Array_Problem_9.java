package arrays;
import java.util.*;

//Minimize the maximum difference between heights [V.IMP]
public class Array_Problem_9 {
    // Modifies the array by subtracting/adding k to every element such that the difference
    // between maximum and minimum is minimized
    static int getMinimumDifference(int[] numbers, int numberOfElements, int adjustmentValue) {
        if (numberOfElements == 1) {
            return 0;
        }

        // Sort all elements
        Arrays.sort(numbers);

        // Initialize result
        int difference = numbers[numberOfElements - 1] - numbers[0];

        // Handle corner elements
        int smallestAdjustedValue = numbers[0] + adjustmentValue;
        int largestAdjustedValue = numbers[numberOfElements - 1] - adjustmentValue;
        int temp;

        if (smallestAdjustedValue > largestAdjustedValue) {
            temp = smallestAdjustedValue;
            smallestAdjustedValue = largestAdjustedValue;
            largestAdjustedValue = temp;
        }

        // Traverse middle elements
        for (int i = 1; i < numberOfElements - 1; i++) {
            int subtractValue = numbers[i] - adjustmentValue;
            int addValue = numbers[i] + adjustmentValue;

            // If both subtraction and addition do not change the difference, skip
            if (subtractValue >= smallestAdjustedValue || addValue <= largestAdjustedValue) {
                continue;
            }

            // Update smallest or largest value based on their impact on the difference
            if (largestAdjustedValue - subtractValue <= addValue - smallestAdjustedValue) {
                smallestAdjustedValue = subtractValue;
            } else {
                largestAdjustedValue = addValue;
            }
        }

        return Math.min(difference, largestAdjustedValue - smallestAdjustedValue);
    }

    // Driver function to test the above function
    public static void main(String[] args) {
        int[] numbers = {4, 6};
        int numberOfElements = numbers.length;
        int adjustmentValue = 10;

        System.out.println("Minimum difference after adjustment: " +
                getMinimumDifference(numbers, numberOfElements, adjustmentValue));
    }

}
