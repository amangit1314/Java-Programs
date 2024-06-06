package searchingSortingProblems;

import java.util.Arrays;

public class SSP_Problem_16 {

    public static int[] productExceptSelf(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0]; // Handle empty array
        }

        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Build prefix product array
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        // Build suffix product array
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        // Calculate product array using prefix and suffix
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int[] result = productExceptSelf(arr);
        System.out.println("Product array: " + Arrays.toString(result));
    }

}
