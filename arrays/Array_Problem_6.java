package arrays;

// A Java program to print union and intersection of two unsorted arrays
import java.util.Arrays;

/*a
 * Find the Union and Intersection of the two sorted arrays.
 */

public class Array_Problem_6 {

	void printUnion(int[] firstArray, int[] secondArray, int firstArrayLength, int secondArrayLength) {
        // Ensure the first array is smaller or equal in length
        if (firstArrayLength > secondArrayLength) {
            int[] temp = firstArray;
            firstArray = secondArray;
            secondArray = temp;

            int tempLength = firstArrayLength;
            firstArrayLength = secondArrayLength;
            secondArrayLength = tempLength;
        }

        // Sort the smaller array
        Arrays.sort(firstArray);
        for (int element : firstArray) {
            System.out.print(element + " ");
        }

        // Find elements in the larger array not present in the smaller array
        for (int i = 0; i < secondArrayLength; i++) {
            if (binarySearch(firstArray, 0, firstArrayLength - 1, secondArray[i]) == -1) {
                System.out.print(secondArray[i] + " ");
            }
        }
    }

    void printIntersection(int[] firstArray, int[] secondArray, int firstArrayLength, int secondArrayLength) {
        // Ensure the first array is smaller or equal in length
        if (firstArrayLength > secondArrayLength) {
            int[] temp = firstArray;
            firstArray = secondArray;
            secondArray = temp;

            int tempLength = firstArrayLength;
            firstArrayLength = secondArrayLength;
            secondArrayLength = tempLength;
        }

        // Sort the smaller array
        Arrays.sort(firstArray);

        // Find elements in the larger array present in the smaller array
        for (int i = 0; i < secondArrayLength; i++) {
            if (binarySearch(firstArray, 0, firstArrayLength - 1, secondArray[i]) != -1) {
                System.out.print(secondArray[i] + " ");
            }
        }
    }

    int binarySearch(int[] array, int low, int high, int element) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (array[mid] == element) {
                return mid;
            }

            if (array[mid] > element) {
                return binarySearch(array, low, mid - 1, element);
            }

            return binarySearch(array, mid + 1, high, element);
        }

        return -1;
    }

    public static void main(String[] args) {
        Array_Problem_6 unionAndIntersection = new Array_Problem_6();

        int[] firstArray = {7, 1, 5, 2, 3, 6};
        int[] secondArray = {3, 8, 6, 20, 7};

        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;

        System.out.println("Union of two arrays is: ");
        unionAndIntersection.printUnion(firstArray, secondArray, firstArrayLength, secondArrayLength);

        System.out.println();

        System.out.println("Intersection of two arrays is: ");
        unionAndIntersection.printIntersection(firstArray, secondArray, firstArrayLength, secondArrayLength);
    }
	}

