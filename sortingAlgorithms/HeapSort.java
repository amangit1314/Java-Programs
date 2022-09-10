package sortingAlgorithms;
import java.util.*;
//Java program for implementation of Heap Sort 
public class HeapSort {
	
	public void sort(int A[]) {
		
		int n = A.length;
		
		for(int i=n/2;i>=0;i--) 
			heapify(A,n,i);	
		
		for(int i = n-1;i>0;i--) {
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			
			heapify(A,i,0);
		}
	}
	
	void heapify(int A[], int n, int i) {

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

		 /* A utility function to print arrays.array of size n */
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
			
			 @SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			 int n = sc.nextInt();
			 int A[] = new int[n];
				
			 for(int i=0;i<n;i++) 
					A[i] = sc.nextInt();
		     
		     HeapSort ob = new HeapSort(); 
		     ob.sort(A); 

		     System.out.println("Sorted arrays.array is");
		     printArray(A); 
		 } 
} 

