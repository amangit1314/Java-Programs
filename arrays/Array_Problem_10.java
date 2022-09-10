package arrays;
import java.util.*;
import java.io.*;

/*
 *  Problem :- 
 *   Minimum no of jumps to reach end of an arrays.array
 */

/* 
 * Understanding of The Problem: - 
 * 
 * Given an arrays.array of integers where each element represents the max number of steps that can be made forward from the element
 * Write a function to return the minimum no of jumps to reach the end of the arrays.array(starting from the first element).
 * If an element is 0, they cannot move through that element.
 */
@SuppressWarnings("unused")
public class Array_Problem_10 {
	
	static int minJumps(int arr[] , int l , int h) {
		
		//Base case: when source & destination are same
		if(h == l)
			return 0;
		
		//When nothing is reachable from the given source
		if(arr[l] == 0)		
			return Integer.MAX_VALUE;
		
		/*
		 * Traverse through all the points reachable from arrays.array[1].
		 * Recursively get the minimum number of jumps needed to reach arrays.array[h] from these reachable points.
		 */
		
		int min = Integer.MAX_VALUE;
		for(int i = l + 1 ; i <= h 
				&& i<= l + arr[l] ; i++) {
			int jumps = minJumps(arr , i , h);
			if(jumps != Integer.MAX_VALUE	  &&	  jumps + 1 < min)	
				min = jumps + 1 ;
		}
		return min;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		int n = arr.length;
		System.out.print("Minimum number of jumps to reach end is " + minJumps(arr , 0 , n -1 ));
	}

}
