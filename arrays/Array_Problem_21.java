package arrays;
/*
 * Problem Title :->
 * Find if there is any sub arrays.array with sum equal to 0
 */

import java.util.*;

/*
 *  Generalisation
 *	a[2, 3, -1, -2, 4, 5]; -> The arrays.array
 * 	here their are n^2 + 1 sub arrays, in an arrays.array of any size n.
 * now the sub arrays.array of have a sum equal to zero is from index a[1] to index a[3] in this case.
 */

public class Array_Problem_21 {

    static boolean subArrayExists(int[] array) {
        // Create an empty HashSet to store seen sums
        Set<Integer> seenSums = new HashSet<>();
        // Initialize the sum of elements
        int currentSum = 0;

        // Traverse through the array
        for (int i = 0; i < array.length; i++) {
            // Add current element to the sum
            currentSum += array[i];

            /*
             * Return true in the following cases:
             * a) Current element is 0.
             * b) Sum of elements from 0 to i is 0.
             * c) Current sum is already present in the hash set.
             */
            if (array[i] == 0 || currentSum == 0 || seenSums.contains(currentSum)) {
                return true;
            }

            // Add the current sum to the set
            seenSums.add(currentSum);
        }

        // We reach here only when there is no subarray with 0 sum
        return false;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] array = {2, 3, -1, -2, 4, 5};
        if (subArrayExists(array)) {
            System.out.println("Found a subarray with 0 sum");
        } else {
            System.out.println("No such subarray exists!");
        }
    }
}
