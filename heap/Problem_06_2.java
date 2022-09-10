package heap;

// Problem Title => Java program to merge k sorted arrays of size n each.

// A min heap node
class MinHeapNode {
    // The element to be stored
    int element;

    // index of the arrays.array from which the element is taken
    int i;

    // index of the next element to be picked from arrays.array
    int j;

    public MinHeapNode(int element, int i, int j) {
        this.element = element;
        this.i = i;
        this.j = j;
    }
}

// A class for Min Heap
public class Problem_06_2 {

    // Array of elements in heap
    MinHeapNode[] harr;

    // Current number of elements in min heap
    int heap_size;

    // Constructor: Builds a heap from a given arrays.array a[] of given size
    public Problem_06_2(MinHeapNode[] a, int size) {
        heap_size = size;
        harr = a;
        int i = (heap_size - 1)/2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    // A recursive method to heapify a subtree with the root at given index This method assumes that the subtrees are already heapified
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l].element < harr[i].element)
            smallest = l;
        if (r < heap_size && harr[r].element < harr[smallest].element)
            smallest = r;
        if (smallest != i) {
            swap(harr, i, smallest);
            MinHeapify(smallest);
        }
    }

    // to get index of left child of node at index i
    int left(int i) { return (2*i + 1); }

    // to get index of right child of node at index i
    int right(int i) { return (2*i + 2); }

    // to get the root
    MinHeapNode getMin() {
        if(heap_size <= 0) {
            System.out.println("Heap underflow");
            return null;
        }
        return harr[0];
    }

    // to replace root with new node "root" and heapify() new root
    void replaceMin(MinHeapNode root) {
        harr[0] = root;
        MinHeapify(0);
    }

    // A utility function to swap two min heap nodes
    void swap(MinHeapNode[] arr, int i, int j) {
        MinHeapNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // A utility function to print arrays.array elements
    static void printArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    // This function takes an arrays.array of arrays as an argument and All arrays are assumed to be sorted.
    // It merges them together and prints the final sorted output.
    static void mergeKSortedArrays(int[][] arr, int k) {
        MinHeapNode[] hArr = new MinHeapNode[k];
        int resultSize = 0;
        for(int i = 0; i < arr.length; i++) {
            MinHeapNode node = new MinHeapNode(arr[i][0],i,1);
            hArr[i] = node;
            resultSize += arr[i].length;
        }

        // Create a min heap with k heap nodes.
        // Every heap node has first element of an arrays.array
        Problem_06_2 mh = new Problem_06_2(hArr, k);

        // To store output arrays.array
        int[] result = new int[resultSize];

        // Now one by one get the minimum element from min heap and replace it with next element of its arrays.array
        for(int i = 0; i < resultSize; i++) {
            // Get the minimum element and store it in result
            MinHeapNode root = mh.getMin();
            result[i] = root.element;

            // Find the next element that will replace current root of heap.
            // The next element belongs to same arrays.array as the current root.
            if(root.j < arr[root.i].length)
                root.element = arr[root.i][root.j++];
                // If root was the last element of its arrays.array
            else
                root.element = Integer.MAX_VALUE;

            // Replace root with next element of arrays.array
            mh.replaceMin(root);
        }

        printArray(result);
    }

    // Driver code
    public static void main(String[] args){
        int[][] arr= {
                {2,   6, 12, 34},
                {1,   9, 20, 1000},
                {23, 34, 90, 2000}
        };

        System.out.println("Merged arrays.array is :");
        mergeKSortedArrays(arr,arr.length);
    }
}