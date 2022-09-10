package matrix;
// Problem Title => Kth small_est element in a row-column wise sorted matrix
public class Matrix_Problem_09 {

    // A structure to store entry of heap.
    // The entry contains value from 2D arrays.array,
    // row and column numbers of the value
    static class HeapNode {

        // Value to be stored
        int val;

        // Row number of value in 2D arrays.array
        int r;

        // Column number of value in 2D arrays.array
        int c;

        HeapNode(int val, int r, int c) {
            this.val = val;
            this.c = c;
            this.r = r;
        }
    }

    // A utility function to minheap-ify the node
    // harr[i] of a heap stored in harr[]
    static void minHeapify(HeapNode[] harr, int i, int heap_size) {

        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if(l < heap_size&& r<heap_size && harr[l].val < harr[i].val && harr[r].val < harr[i].val){
            HeapNode temp=harr[r];
            harr[r]=harr[i];
            harr[i]=harr[l];
            harr[l]=temp;
            minHeapify(harr ,l,heap_size);
            minHeapify(harr ,r,heap_size);
        }
        if (l < heap_size && harr[l].val < harr[i].val){
            HeapNode temp=harr[i];
            harr[i]=harr[l];
            harr[l]=temp;
            minHeapify(harr ,l,heap_size);
        }
    }

    // This function returns kth small-est element in a 2D arrays.array mat[][]
    public static int kthSmallest(int[][] mat,int n, int k) {

        // k must be greater than 0 and smaller than n*n
        if (k < 0 && k >= n * n)
            return Integer.MAX_VALUE;

        // Create a min heap of elements from first row of 2D arrays.array
        HeapNode[] harr = new HeapNode[n];

        for(int i = 0; i < n; i++) {
            harr[i] = new HeapNode(mat[0][i], 0, i);
        }

        HeapNode hr = new HeapNode(0, 0, 0);

        for(int i = 1; i <= k; i++) {

            // Get current heap root
            hr = harr[0];

            // Get next value from column of root's value.
            // If the value stored at root was last value in its column,
            // then assign INFINITE as next value
            int nextVal = hr.r < n - 1 ?
                    mat[hr.r + 1][hr.c] :
                    Integer.MAX_VALUE;

            // Update heap root with next value
            harr[0] = new HeapNode(nextVal,
                    hr.r + 1, hr.c);

            // Heapify root
            minHeapify(harr, 0, n);
        }

        // Return the value at last extracted root
        return hr.val;
    }
    public static void main(String[] args) {
        int[][] mat = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 25, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        int res = kthSmallest(mat, 4, 7);

        System.out.print("7th smallest element is "+ res);
    }
}
