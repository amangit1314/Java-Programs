package arrays;
import java.util.*;
import java.io.*;

/*
 *  Problem :-
 *   Minimum no of jumps to reach end of an arrays.array
 */

/*
 * Understanding of The Problem: -
 *
 * Given an arrays.array of integers where each element represents the max number of steps that can be made forward from the element
 * Write a function to return the minimum no of jumps to reach the end of the arrays.array(starting from the first element).
 * If an element is 0, they cannot move through that element.
 */
@SuppressWarnings("unused")
public class Array_Problem_10 {

	// Function to find the minimum number of jumps required to reach the end of the array
    public static int findMinimumJumps(int[] jumpDistances, int startingIndex, int endingIndex) {
        // Base case: destination reached from the source itself
        if (startingIndex == endingIndex) {
            return 0;
        }

        // Base case: no jump possible from the source
        if (jumpDistances[startingIndex] == 0) {
            return Integer.MAX_VALUE;
        }

	/*
		 * Traverse through all the points reachable from arrays.array[1].
		 * Recursively get the minimum number of jumps needed to reach arrays.array[h] from these reachable points.
		 */
        // Explore all reachable destinations from the current position
        int minJumps = Integer.MAX_VALUE;
        for (int nextIndex = startingIndex + 1; nextIndex <= endingIndex && nextIndex <= startingIndex + jumpDistances[startingIndex]; nextIndex++) {
            int jumpsFromNextIndex = findMinimumJumps(jumpDistances, nextIndex, endingIndex);

            // Update minimum jumps if a valid path is found
            if (jumpsFromNextIndex != Integer.MAX_VALUE && jumpsFromNextIndex + 1 < minJumps) {
                minJumps = jumpsFromNextIndex + 1;
            }
        }

        return minJumps;
    }

    public static void main(String[] args) {
        int[] jumpDistances = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int numberOfElements = jumpDistances.length;

        System.out.println("Minimum number of jumps to reach the end: " + findMinimumJumps(jumpDistances, 0, numberOfElements - 1));
    }

}
