package searchingSortingProblems;
import java.util.*;

// Problem Title => Find Pair Given Difference
public class SSP_Problem_10 {

    // The function assumes that the arrays.array is sorted
     public static void findPair(int[] arr, int d, int size) {
        Arrays.sort(arr);
        
        // Initialize positions of two elements
        int i = 0, j = 1;

        // Search for a pair
        while (i < size && j < size) {
            if (i != j && (arr[j] - arr[i] == d || arr[i] - arr[j] == d)) {
                System.out.print("Pair Found: " + "( " + arr[i] + ", " + arr[j] + " )");
                return;
            }
            else if (arr[j] - arr[i] < d)
                j++;
            else
                i++;
        }

        System.out.print("No such pair");
     }

    // Driver Function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        // Sorting the arrays.array
        Arrays.sort(arr);

        // check for the pair
        findPair(arr, d, size);
    }
}
