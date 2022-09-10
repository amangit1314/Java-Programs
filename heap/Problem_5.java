package heap;
// Problem Title => Find Kith the smallest element in an Unsorted Array

public class Problem_5 {
    // A class for Max Heap
    static class MinHeap {

        int[] harr; // pointer to arrays.array of elements in heap
        int capacity; // maximum possible size of min heap
        int heap_size; // Current number of elements in min heap

        int parent(int i) { return (i - 1) / 2; }
        int left(int i) { return ((2 * i )+ 1); }
        int right(int i) { return ((2 * i) + 2); }
        int getMin() { return harr[0]; } // Returns minimum

        // to replace root with new node x and heapify() new root
        void replaceMax(int x) {
            this.harr[0] = x;
            minHeapify(0);
        }

        // Constructor
        MinHeap(int[] a, int size) {
            heap_size = size;
            harr = a; // store address of arrays.array
            int i = (heap_size - 1) / 2;
            while (i >= 0) {
                minHeapify(i);
                i--;
            }
        }

        // Method to remove maximum element (or root) from min heap
        int extractMin() {
            if (heap_size == 0)
                return Integer.MAX_VALUE;

            // Store the maximum value.
            int root = harr[0];

            // If there are more than 1 items, move the last item to root and call heapify.
            if (heap_size > 1) {
                harr[0] = harr[heap_size - 1];
                minHeapify(0);
            }
            heap_size--;
            return root;
        }

        // A recursive method to heapify a subtree with root at given index.
        // This method assumes that the subtrees are already heaped
        void minHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if (l < heap_size && harr[l] < harr[i])
                smallest = l;
            if (r < heap_size && harr[r] < harr[smallest])
                smallest = r;
            if (smallest != i) {
                int t = harr[i];
                harr[i] = harr[smallest];
                harr[smallest] = t;
                minHeapify(smallest);
            }
        }
    }

    // Function to return kith the largest element in a given arrays.array
    int kthSmallest(int[] arr, int n, int k) {

        // Build a heap of first k elements: O(k) time
        MinHeap mh = new MinHeap(arr, n);

        // Process remaining n-k elements.
        // If current element is smaller than root, replace root with current element
        for (int i = 0; i < k - 1; i++)
            mh.extractMin();

        // Return root
        return mh.getMin();
    }

    // Driver program to test above methods
    public static void main(String[] args) {
        int[] arr = { 12, 3, 5, 7, 19 };
        int n = arr.length, k = 2;
        Problem_5 heap = new Problem_5();
        System.out.print("Kith smallest element is " + heap.kthSmallest(arr, n, k));
    }
}