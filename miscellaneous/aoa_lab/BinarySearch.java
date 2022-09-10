package miscellaneous.aoa_lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearch {

    int count = 0;

    public static int getRandomValue(int Min, int Max) {
        // Get and return the random integer within Min and Max
        return ThreadLocalRandom.current().nextInt(Min, Max + 1);
    }

    int binarySearch(int[] arr, int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x){
                count++;
                return mid;
            }


            // If element is smaller than mid, then it can only be present in left sub-arrays.array
            if (arr[mid] > x){
                count++;
                return binarySearch(arr, l, mid - 1, x);
            }

            // Else the element can only be present in right sub-arrays.array
            return binarySearch(arr, mid + 1, r, x);
        }

        System.out.println(count);

        // We reach here when element is not present in arrays.array
        return -1;
    }

    public static void main(String[] args) {

        BinarySearch ob = new BinarySearch();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  x;

        System.out.println("Enter Min and Max range of random values");
        int Min = sc.nextInt(), Max = sc.nextInt();

        System.out.println("Input elements of arrays.array");
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = getRandomValue(Min, Max);
            System.out.println(a[i] + " ");
        }

        System.out.println("Enter the value to be found");
        x = sc.nextInt();

        Arrays.sort(a);
        int result = ob.binarySearch(a, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else{
            System.out.println("Element found at index " + result);
        }

    }
}