package matrix;
//Kth smallest element in a row-column wise sorted matrix
public class Matrix_Problem_09 {
    static class HeapNode{
        int val;
        int r, c;

        HeapNode(int val, int r, int c){
            this.val = val;
            this.c = c;
            this.r = r;
        }
    }
    static void swap(int i, int min, HeapNode[] a){
        HeapNode temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }

    static void minHeapify(HeapNode[] ha, int i, int heap_size){
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int min = i;

        if(l < heap_size && ha[l].val < ha[i].val)
            min = l;
        if(r < heap_size && ha[r].val < ha[i].val)
            min = r;
        if(min != i){
            swap(i, min, ha);
            minHeapify(ha, min, heap_size);
        }
    }
    static void buildHeap(HeapNode[] ha, int n){
        int i = (n - 1)/2;
        while(i > 0){
            minHeapify(ha, i, n);
            i--;
        }
    }
    public static int kthSmallest(int[][] mat, int n, int k){
        if(k <= 0 || k > n*n)
            return Integer.MAX_VALUE;

        HeapNode[] ha = new HeapNode[n];
        for (int i = 0; i < n; i++)
               ha[i]= new HeapNode(mat[0][i], 0, i);

        buildHeap(ha, n);

        HeapNode hr = new HeapNode(0,0,0);

        for (int i = 1; i < k; i++){
            hr = ha[0];
            int nextVal = hr.r < n - 1 ? mat[hr.r+1][hr.c] : Integer.MAX_VALUE;
            ha[0] = new HeapNode(nextVal, hr.r + 1, hr.c);
            minHeapify(ha, 0, n);
        }
        return hr.val;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int res = kthSmallest(mat, 4, 7);
        System.out.print("7th smallest element is " + res);
    }
}
