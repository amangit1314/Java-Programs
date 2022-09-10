package searchingSortingProblems;

import java.util.Scanner;

// Problem Title => Maximum and minimum of an arrays.array using minimum number of comparisons
public class SSP_Problem_05 {

    static class Pair{
        int max;
        int min;
    }

    static Pair getMinMax(int[] arr, int low, int high) {
        Pair minmax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();
        int mid;

        // If there is only one element
        if (low == high) {
            minmax.max = arr[low];
            minmax.min = arr[low];
            return minmax;
        }

        /* If there are two elements */
        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                minmax.max = arr[low];
                minmax.min = arr[high];
            } else {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }

        /* If there are more than 2 elements */
        mid = (low + high) / 2;
        mml = getMinMax(arr, low, mid);
        mmr = getMinMax(arr, mid + 1, high);

        /* compare minimums of two parts*/
        minmax.min = Math.min(mml.min, mmr.min);

        /* compare maximums of two parts*/
        minmax.max = Math.max(mml.max, mmr.max);

        return minmax;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr_size = sc.nextInt();

        int[] arr = new int[arr_size];
        for (int i = 0; i < arr_size; i++){
            arr[i] = sc.nextInt();
        }

        Pair minmax = getMinMax(arr, 0, arr_size - 1);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }
}

// Time Complexity => O(n) [It means Linear Time will be taken].
// Space Complexity => O(1) [Constant Time will be taken].
