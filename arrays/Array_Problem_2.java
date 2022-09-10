package arrays;

//Java program to find the maximum & minimum element in given or arrays.array as user input
public class Array_Problem_2 {
/* Class Pair is used to return two values from getMinMax() */
    static class Pair {
 
        int min;
        int max;
    }
 
    static Pair getMinMax(int[] arr, int n) {
        Pair minmax = new  Pair();
 
        /*If there is only one element then return it as min and max both*/
        if (n == 1) {
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }
 
        /* If there are more than one element, then initialize min and max*/
        if (arr[0] > arr[1]) {
            minmax.max = arr[0];
            minmax.min = arr[1];
        } else {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }
 
        for (int i = 2; i < n; i++) {
            if (arr[i] > minmax.max)
                minmax.max = arr[i];
            else if (arr[i] < minmax.min)
                minmax.min = arr[i];
        }
 
        return minmax;
    }
 
    /* Driver program to test above function */
    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int n = 6;
        Pair minmax = getMinMax(arr, n);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
 
    }
 
}

