package searchingAlgorithms;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/* Problem Title => Implement Binary Search algo and compute the comparison to find an element in following scenarios:
    1. Searching in 10 elements
    2. Searching in 100 elements
    3. Searching in 1000 elements
 */

public class BinarySearch {
    static int count = 0;

    public static int getRandomValue(int Min, int Max) {
        // Get and return the random integer within Min and Max
        return ThreadLocalRandom.current().nextInt(Min, Max + 1);
    }

    int binarySearch(int[] arr, int left, int right, int element) {

        // checking if right is greater or equal to left
        if (right >= left) {
            // mid-element of arrays.array
            int mid = left + (right - left) / 2;

            // If the element is present at the middle itself
            if (arr[mid] == element){
                count++;
                return mid;
            }

            // If element is smaller than mid, then it can only be present in left sub-arrays.array
            if (arr[mid] > element){
                count++;
                return binarySearch(arr, left, mid - 1, element);
            }

            count++;
            // Else the element can only be present in right sub-arrays.array
            return binarySearch(arr, mid + 1, right, element);
        }

        // We reach here when element is not present in arrays.array
        return -1;
    }

    // Driver method to test above
    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        Scanner sc = new Scanner(System.in);

        int Min = 1, Max = 100;

        int n = sc.nextInt();
        sc.close();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = getRandomValue(Min, Max);
            System.out.print(arr[i] + " ");
        }

        Arrays.sort(arr);
        int element = sc.nextInt();
        int result = ob.binarySearch(arr, 0, n - 1, element);

        if (result == -1){
            System.out.println("Element not present ❌");
            count++;
        }

        else{
            count++;
            System.out.println("Comparisons => ");
            System.out.print(count);
            System.out.println("Element found ✔ at index => " + result);
        }

        System.out.println();

        System.out.println("Comparisons => ");
        System.out.print(count);
    }
}