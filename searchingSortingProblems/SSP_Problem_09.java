import java.util.*;
import java.lang.*;
import java.util.Scanner;


// Program Title => Searching in an arrays.array where adjacent differ at most k.
/* example : 
 I/P = a[] = {4, 5, 6, 7, 6}, k = 1, x = 6.
 O/P = 2
 This first index of 6 is 2. 
*/

public class SSP_Problem_09 {

    // x is the element to be searched in arr[0..n-1] such that all elements differ by at-most k.
    static int search(int[] a, int n, int x, int k) {
        // Traverse the given arrays.array starting leftmost element
        int i = 0;
        while (i < n) {
            if (a[i] == x)
                return i;

            // Jump the difference between current arrays.array element
            // and x divided by k We use max here to make sure that i moves at-least one step ahead.
            i = i + Math.max(1, Math.abs(a[i] - x) / k);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Element " + x + " is present at index " + search(a, n, x, k));
    }
}