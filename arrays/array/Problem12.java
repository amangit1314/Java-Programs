package arrays.array;
import java.util.*;

// TITLE => Merge 2 sorted arrays without using Extra space.
public class Problem12{

    static void merge(int[] arr1, int[] arr2, int m, int n) {
        // Iterate through all elements of ar2[] starting from
        // the last element
        for (int i = n-1; i >= 0; i--) {
            /* Find the smallest element greater than ar2[i]. Move all
               elements one position ahead till the smallest greater
               element is not found */
            int j, last = arr1[m-1];
            for (j = m-2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j+1] = arr1[j];

            // If there was a greater element
            if (j != m-2 || last > arr2[i]) {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // size or length of arr1[]
        int m = sc.nextInt();
        // input elements of arr1[]
        int[] arr1 = new int[m];
        for(int i = 0; i < m; i++)
            arr1[i] = sc.nextInt();

        // size or length of arr2[]
        int n = sc.nextInt();
        // input elements of arr2[]
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++)
            arr2[i] = sc.nextInt();

        // Call function merge
        merge(arr1, arr2,m,n);
        System.out.print("After Merging nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }
}