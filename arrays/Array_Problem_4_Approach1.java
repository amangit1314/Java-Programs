
package arrays;
import java.io.*;

/*
 * Java program to solve that,
 * Given an arrays.array A of size N containing 0s, 1s, and 2s;
 * you need to sort the arrays.array in ascending order without using any sorting algorithm
 */

@SuppressWarnings("unused")
public class Array_Problem_4_Approach1 {
	  
	    // Sort the input arrays.array, the arrays.array is assumed they have values in {0, 1, 2}
	    static void sort012(int[] arr, int arr_size) {
	        int lo = 0; 
	        int hi = arr_size - 1;
	        int mid = 0, temp;
	        while (mid <= hi) { 
	            switch (arr[mid]) {
	            	case 0: {
	                	temp = arr[lo];
						arr[lo] = arr[mid];
						arr[mid] = temp;
	                	lo++;
	                	mid++;
	                	break;
	            	}
	            	case 1:
	                	mid++;
	                	break;
	            	case 2: {
	                	temp = arr[mid];
						arr[mid] = arr[hi];
						arr[hi] = temp;
	                	hi--;
	                	break;
	            	}
	            } 
	        } 
	    } 
	  
	    /* Utility function to print arrays.array arr[] */
	    static void printArray(int[] arr, int arr_size) {
	        int i; 
	        for (i = 0; i < arr_size; i++) 
	            System.out.print(arr[i] + " "); 
	        System.out.println();
	    } 
	  
	    /*Driver function to check for above functions*/
	    public static void main(String[] args) {
	        int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
	        int arr_size = arr.length; 
	        sort012(arr, arr_size); 
	        System.out.println("Array after segregation ");
	        printArray(arr, arr_size); 
	    }
}
