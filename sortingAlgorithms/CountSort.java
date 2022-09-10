package sortingAlgorithms;

// Java implementation of Counting Sort

class CountingSort {
    void sort(char[] arr) {
        int n = arr.length;

        // The output character arrays.array that will have sorted arr
        char[] output = new char[n];

        // Create a count arrays.array to store count of individual characters and initialize count arrays.array as 0
        int[] count = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;

        // store count of each character
        for (char c : arr) ++count[c];

        // Change count[i] so that count[i] now contains actual position of this character in output arrays.array
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];

        // Build the output character arrays.array To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output arrays.array to arr, so that arr now contains sorted characters
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Driver method
    public static void main(String[] args) {
        CountingSort ob = new CountingSort();
        char[] arr = { 'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's' };

        ob.sort(arr);

        System.out.print("Sorted character arrays.array is ");
        for (char c : arr) System.out.print(c);
    }
}