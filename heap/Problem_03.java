package heap;
import java.util.*;
// Problem Title => the maximum for each and every contiguous sub-arrays.array of size k.
public class Problem_03 {

    // function to printKMax
    static void printKMax(int[] a, int n, int k){
        int j, max;
        for(int i = 0; i <= n - k; i++){
            max = a[i];
            for (j = 1; j < k; j++) {
                if (a[i + j] > max)
                    max = a[i + j];
            }
            System.out.print(max + " ");
        }
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        printKMax(a, a.length, k);
    }
}