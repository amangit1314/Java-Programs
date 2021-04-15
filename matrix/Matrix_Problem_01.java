package matrix;
import java.io.*;

/*
 * Spiral traversal on a Matrix
 */

/*
 * GIven an 2D array, print it in spiral form.
 * See the following examples.
 * 
 * Inputs:
 * 01 02 03 04
 * 05 06 07 08
 * 09 10 11 12
 * 13 14 15 16
 * 
 * Output:
 * 1 2 3 4 8 12 16 15  14 13 9 5 6 7 11 10
 * 
 * Explanation:
 * The output is matrix in spiral format.
 */

/* Graphical Try:
 * 
 * 01-- 02-- 03-- 04
 *                |
 * 05-- 06-- 07   08
 * |         |    |
 * 09   10   11   12
 * |              |
 * 13-- 14-- 15 --16
 *
 * Output:
 * 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
 */

@SuppressWarnings("unused")
public class Matrix_Problem_01 {
	
	static void spiralPrint(int m, int n, int[][] a) {
		
		System.out.println("Spiral Traversal of given matrix is: ");
		int i, k = 0, l = 0;
		
		/*
		 * k - starting row index
		 * m - ending row index
		 * l - starting column index
		 * n - ending column index
		 * i - iterator
		 */
		
		while(k < m && l < n) {
			
			
			for( i = l ; i < n ; ++i) 
				System.out.print(a[k][i] + " ");
			k++;
			
			for(i = k ; i < m ; ++i) 
				System.out.print(a[i][n - 1] + " ");
			n--;
			
			if(l < n) {
				for(i = m - 1 ; i >= k ; --i) 
					System.out.print(a[i][l] + " ");
				l++;
			}
		}
		
	}

	public static void main(String[] args) {
		
		int R = 3;
		int C = 6;
		int a[][] = { { 1 , 2 , 3 , 4 , 5 , 6 },
					  { 7 , 8 , 9 , 10 , 11 , 12 },
					  { 13 , 14 , 15 , 16 , 17 , 18 }
					};
		
		spiralPrint(R,C,a);
	}

}
