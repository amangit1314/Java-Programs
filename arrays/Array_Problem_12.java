package arrays;

import java.util.Arrays;

/*
 * Problem :-
 * Merge two sorted arrays.array without using extra space
 */

/*
 * Understanding of the Problem :-
 * 
 * We are given two sorted arrays.array.
 * We need to merge these two arrays, 
 * such that the initial numbers(after complete sorting) are in the first arrays.array ,
 * and the remaining numbers are in the second arrays.array.
 * Extra space allowed in O(1). 
 */

/*
 * Simple Discussion :
 * This task is simple and O(m+n) if we are allowed to use extra space.
 * But it becomes really complicated when extra space is not allowed,
 * and doesn't look possible in less than O(m*n) worst case time.
 */

/*
 * Idea or Approach of Solution :-
 * The idea is to begin from last element of ar2[] and search it in ar1[].
 * If there is a greater element in ae1[], then we moe lastt element of ar2[] at correct place in ar1[].
 * 
 * We can use INSERTION Sort type of insertion for this.
 */

public class Array_Problem_12 {
	
	static int[] arr1 = new int[] {1, 5 , 9, 10, 15, 20};
	static int[] arr2 = new int[] {2, 3, 8, 13};
	
	static void merge(int m , int n) {
		
		//Iterate through all elements of the last element 
		for(int i = n-1; i >= 0; i--) {
			
			/*
			 * FInd the smallest element greater than ar2[i].
			 * Move all elements one position ahead till the smallest greater element is not found.
			 */
			int j , last = arr1[m -1];
			for( j = m-2 ; j>= 0  && arr1[j] > arr2[i] ; j--)
				arr1[j+1] = arr1[j];
			
			//if there was a greater element 
			if(j != m-2 || last > arr2[i]) {
				arr1[j+1] = arr2[i];
				arr2[i] = last;
			}
		}
	}

	public static void main(String[] args) {
		merge(arr1.length, arr2.length);
		System.out.println("After Merging nFirst Array: ");
		System.out.println(Arrays.toString(arr1));
		System.out.println("Second Array: ");
		System.out.println(Arrays.toString(arr2));
	}

}
