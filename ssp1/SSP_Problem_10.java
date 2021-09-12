import java.util.*;

// Problem Title => Find Pair Given Difference
public class SSP_Problem_10 {

    // The function assumes that the array is sorted
    static boolean findPair(int[] a, int d, int size) {
        Arrays.sort(a);
        
        // Initialize positions of two elements
        int i = 0, j = 1;

        // Search for a pair
        while (i < size && j < size) {
            if (i != j && (arr[j] - arr[i] == n || arr[i] - arr[j] == n)) {
                System.out.print("Pair Found: " + "( " + arr[i] + ", " + arr[j] + " )");
                return true;
            } else if (arr[j] - arr[i] < n)
                j++;
            else
                i++;
        }

        System.out.print("No such pair");
        return false;
    }

    // Driver Function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[size];
        for(int i = 0; i < size; i++)
            a[i] = sc.nextInt();

        // Sorting the array
        Arrays.sort(a);

        // check for the pair
        findPair(a, d);
    }
}
