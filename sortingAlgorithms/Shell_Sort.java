package sortingAlgorithms;
// Problem Title => Implement She'll Sort

/*
* ShellSort is mainly a variation of Insertion Sort.
* In insertion sort, we move elements only one position ahead.
* When an element has to be moved far ahead, many movements are involved.
* The idea of shellSort is to allow exchange of far items.
* In shellSort, we make the arrays.array h-sorted for a large value of h.
* We keep reducing the value of h until it becomes
* 1. An arrays.array is said to be h-sorted if all sub-linkedList.list's of every h’th element is sorted.
*
* */

public class Shell_Sort {
    /* A utility function to print arrays.array of size n*/
    static void printArray(int[] arr) {
        // int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    /* function to sort arr using shellSort */
    int sort(int[] arr) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Do a gaped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already in gaped order keep adding one more element until the entire arrays.array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add a[i] to the elements that have been gap sorted save a[i] in temp and make a hole at position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct location
                arr[j] = temp;
            }
        }
        return 0;
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};
        System.out.println("Array before sorting");
        printArray(arr);

        Shell_Sort ob = new Shell_Sort();
        ob.sort(arr);

        System.out.println("Array after sorting");
        printArray(arr);
    }
}

