package sortingAlgorithms;

public class SelectionSort {

    void sort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted sub-arrays.array
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted arrays.array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Prints the arrays.array
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver code to test above
    public void main(String args[]){
        SelectionSort ob = new SelectionSort();
        int arr[] = {5,11,13,6,12};
        ob.sort(arr);
        System.out.println("Sorted arrays.array");
        ob.printArray(arr);
    }
}
