package sortingAlgorithms;
//Java program for implementation of Heap Sort 
public class HeapSort 
{ 
 public void sort(int A[]) 
 { 
     int n = A.length; 

     // Build heap (rearrange array) 
     for (int i = n / 2 - 1; i >= 0; i--) 
         heapify(A, n, i); 

     // One by one extract an element from heap 
     for (int i=n-1; i>0; i--) 
     { 
         // Move current root to end 
         int temp = A[0]; 
         A[0] = A[i]; 
         A[i] = temp; 

         // call max heapify on the reduced heap 
         heapify(A, i, 0); 
     } 
 } 

 // To heapify a subtree rooted with node i which is 
 // an index in arr[]. n is size of heap 
 void heapify(int A[], int n, int i) 
 { 
     int largest = i; // Initialize largest as root 
     int l = 2*i + 1; // left = 2*i + 1 
     int r = 2*i + 2; // right = 2*i + 2 

     // If left child is larger than root 
     if (l < n && A[l] > A[largest]) 
         largest = l; 

     // If right child is larger than largest so far 
     if (r < n && A[r] > A[largest]) 
         largest = r; 

     // If largest is not root 
     if (largest != i) 
     { 
         int swap = A[i]; 
         A[i] = A[largest]; 
         A[largest] = swap; 

         // Recursively heapify the affected sub-tree 
         heapify(A, n, largest); 
     } 
 } 

 /* A utility function to print array of size n */
 static void printArray(int A[]) 
 { 
     int n = A.length; 
     for (int i=0; i<n; ++i) 
         System.out.print(A[i]+" "); 
     System.out.println(); 
 } 

 // Driver program 
 public static void main(String args[]) 
 { 
     int A[] = {2, -1, 1,4,3, 5, 6, 7}; 
     @SuppressWarnings("unused")
	int n = A.length; 

     HeapSort ob = new HeapSort(); 
     ob.sort(A); 

     System.out.println("Sorted array is"); 
     printArray(A); 
 } 
} 

