package heap;

import java.util.Scanner;
// Problem Title => Implement a Maxheap/MinHeap using arrays and recursion.
public class Problem_01 {

    // function to heapify the tree
    static void heapify(int[] a, int n, int i){

        int largest = i, l = 2*i + 1, r = 2*i + 2;

        if(l < n && a[l] > a[largest])
            largest = l;

        if(r < n && a[r] > a[largest])
            largest = r;

        if(largest != i){
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;
            //recursively heapify the effected sub-tree
            heapify(a, n, largest);
        }
    }

    // Function to build a Max-Heap from the Array
    static void buildHeap(int[] a, int n){
        int startIdx = (n/2)-1;
        for (int i = startIdx; i >= 0; i--){
            heapify(a, n, i);
        }
    }

    // Function to print the heap
    static void printHeap(int[] a, int n){
        System.out.println("Array representation of Heap is:");
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Driver Function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        buildHeap(a, n);
        printHeap(a, n);
    }
}