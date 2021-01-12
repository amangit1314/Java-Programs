package matrix;

/*
 * Title: Find row with maximum no. of 1's
 * We are given a boolean 2D array, where each row is sorted.
 * Find the row with the maximum number of 1s.
 */

/*
 * Example:
 * 0 1 1 1
 * 0 0 1 1
 * 1 1 1 1  "THIS ROW HAS MAXIMUM 1S"
 * 0 0 0 0
 * 
 * Output: 2
 */

/*
 * "A Simplex Method" is to do a row wise traversal of the matrix,
 * count the number of 1s in each row and compare the count with max.
 * Finally, return the index of row with maximum 1s.
 * The time complexity of this method is O(m*n),
 * where m is number of rows and n is number of columns in matrix.
 * 
 * We can do it better. 
 * Since each row is sorted, we can use Binary Search to count of 1s in each row.
 * The count of 1s will be equal to total number of columns minus the index of first 1.
 */

public class Matrix_Problem_04 {

	static int R = 4, C = 4;
	
	// Function to find the index of first index of 1 in a boolean array arr[].
	static int first(int arr[], int low , int high) {
		
		if(high >= low) {
			
			//Get the middle index
			int mid = low + (high - low)/2;
			
			//Check if the element at middle is first 1
			if((mid == 0 || (arr[mid - 1] == 0)) && arr[mid] == 1)
				return mid;
			
			//If the element is 0, recur for right side 
			else if (arr[mid] == 0)
				return first(arr, (mid + 1), high);
			
			//If the element is not first 1, recur for left side
			else 
				return first(arr, low, (mid - 1));
		}
		
		return -1;
	}
	
	//Function that returns index of row with maximum number of 1s
	static int rowWithMaxis(int mat[][]) {
		//Initialize max values
		int max_row_index = 0, max = -1;
		//Traverse for each row and count number of 1s by finding the index of first 1
		int i, index;
		for(i = 0; i < R; i++) {
			index = first(mat[i], 0, C - 1);
			if(index != -1 && C - index > max) {
				max = C - index ;
				max_row_index = i;
			}
		}
		return max_row_index;
	}
	
	//Driver Code
	public static void main(String[] args) {
		int mat[][] = {
				{0, 0, 0, 1},
				{0, 1, 1, 1},
				{1, 1, 1, 1},
				{0, 0, 0, 0} };
		
		System.out.println("Index of row with maximum index is : " + rowWithMaxis(mat));
	}

}
