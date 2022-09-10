package heap;

// Java program to find minimum sum of two numbers formed from digits of the arrays.array.
import java.util.Arrays;

class Problem_18 {

    // Function to find and return minimum sum of two numbers formed from digits of the arrays.array.
    static int solve(int[] arr, int n) {

        // sort the arrays.array
        Arrays.sort(arr);

        // let two numbers be a and b
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            // fill a and b with every alternate digit of input arrays.array
            if (i % 2 != 0)
                a = a * 10 + arr[i];
            else
                b = b * 10 + arr[i];
        }

        // return the sum
        return a + b;
    }

    //driver code
    public static void main (String[] args) {
        int[] arr = {6, 8, 4, 5, 2, 3};
        int n = arr.length;

        System.out.print("Sum is " + solve(arr, n));
    }
}