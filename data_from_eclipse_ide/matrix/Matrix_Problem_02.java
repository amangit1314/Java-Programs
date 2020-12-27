package matrix;

//Search an element in a matrix

/*
 * Example;
 * Consider:    | 1  2  3  4| 
 * x = 3,
 *  mat = | 5  6  7  8|   Middle column:
 *        | 9 10 11 12|    = {2, 6, 10, 14}
 *        |13 14 15 16|   
 *        perform binary search on them
 *           since, x < 6, 
 *           discard the last 2 rows as 'a' will not lie in them(sorted matrix)
 *           Now, only two rows are left
 *            			  | 1  2  3  4| 
 *           x = 3, mat = | 5  6  7  8| 
 *             
 *           Check whether element is present on the middle elements of these rows = {2, 6}
 *           
 *           If x != 2 or 6
 *           
 *           If not, consider the four sub-parts
 *           1st half of 1st row = {1}, 2nd half of 1st row = {3, 4}
 *           1st half of 2nd row = {5}, 2nd half of 2nd row = {7, 8}
 *           
 *           According the value of 'x' it will be searched in the
 *           2nd half of 1st row = {3, 4} and found at (i, j): (0, 2)  
 */
public class Matrix_Problem_02 {

	static int MAX = 100;
	
	static void binarySearch(int mat[][], int i, int j_low, int j_high, int x) {
		
		while(j_low <= j_high) {
			
			int j_mid = (j_low + j_high)/2;
			
			if(mat[i][j_mid] == x) {
				System.out.println("Found at (" + i + "," + j_mid + ")");
				return;
			}
			
			else if(mat[i][j_mid] < x) 
				j_high = j_mid  - 1;
			
			else
				j_low = j_mid + 1;
		}
		
		System.out.println("Element Not Found: ");
	}
	
	static void sortedMatrixSearch(int mat[][], int n, int m, int x) {
		

        // Single row matrix
        if (n == 1)
        {
            binarySearch(mat, 0, 0, m - 1, x);
            return;
        }
     
        // Do binary search in middle column.
        // Condition to terminate the loop when the 2 desired rows are found
        int i_low = 0;
        int i_high = n - 1;
        int j_mid = m / 2;
        
        while ((i_low + 1) < i_high)
        {
            int i_mid = (i_low + i_high) / 2;
     
            // element found
            if (mat[i_mid][j_mid] == x)
            {
                System.out.println ( "Found at (" + i_mid +", " + j_mid +")");
                return;
            }
     
            else if (mat[i_mid][j_mid] > x)
                i_high = i_mid;
     
            else
                i_low = i_mid;
        }
     
        // If element is present on the mid of the two rows
        if (mat[i_low][j_mid] == x)
            System.out.println ( "Found at (" + i_low + "," + j_mid +")");
        
        else if (mat[i_low + 1][j_mid] == x)
            System.out.println ( "Found at (" + (i_low + 1) + ", " + j_mid +")");
     
        // Search element on 1st half of 1st row
        else if (x <= mat[i_low][j_mid - 1])
            binarySearch(mat, i_low, 0, j_mid - 1, x);
     
        // Search element on 2nd half of 1st row
        else if (x >= mat[i_low][j_mid + 1] && x <= mat[i_low][m - 1])
        	binarySearch(mat, i_low, j_mid + 1, m - 1, x);
     
        // Search element on 1st half of 2nd row
        else if (x <= mat[i_low + 1][j_mid - 1])
            binarySearch(mat, i_low + 1, 0, j_mid - 1, x);
     
        // search element on 2nd half of 2nd row
        else
            binarySearch(mat, i_low + 1, j_mid + 1, m - 1, x);
	}
	
	public static void main(String[] args) {
		   int n = 4, m = 5, x = 8;
	       int mat[][] = {{0, 6, 8, 9, 11},
	                       {20, 22, 28, 29, 31},
	                       {36, 38, 50, 61, 63},
	                       {64, 66, 100, 122, 128}};
	     
	        sortedMatrixSearch(mat, n, m, x);
	}

}
