package matrix;
import java.util.*;

/*
 * Title: Maximum size rectangle binary sub-matrix with all 1s
 * 
 * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1's
 */
public class Matrix_Problem_06 {

	static int maxHist(int C, int[] row) {
		
		Stack<Integer> result = new Stack<>();
		int top_val;
		int max_area = 0;
		int area;
		
		int i = 0;
		while(i < C) {
			if(result.empty() || row[result.peek()] <= row[i])
				result.push(i++);
			
			else {
				top_val = row[result.peek()];
				result.pop();
				area = top_val * i;
				
				if(!result.empty())
					area = top_val * (i - result.peek() - 1);
				max_area = Math.max(area,  max_area);
			}
		}
		
		//Now pop the remaining bars stack and calculate area with every popped bar as the smallest bar
		while(!result.empty()) {
			top_val = row[result.peek()];
			result.pop();
			area = top_val * i;
			if(!result.empty())
				area = top_val * (i - result.peek() - 1);
			
			max_area = Math.max(area, max_area);	
		}
		return max_area;
	}
	
	//Returns area of the largest rectangle with all 1s in A[][]
	static int maxRectangle(int R, int C, int[][] A) {
		
		//Calculate area for first row and initialize it as result
		int result = maxHist(C, A[0]);
		
		//iterate over row to find maximum rectangular area considering each row as histogram
		for(int i = 1; i < R; i++) {
			for(int j = 0; j < C; j ++) {
				//if A[i][j] is 1 then Add A[i - 1][j]
				if(A[i][j] == 1)
					A[i][j] += A[i - 1][j];
			}
			
			//Update result if area with current row (as last row of rectangle) is more
			result = Math.max(result, maxHist(C, A[i]));
		}
		return result;
	}
	
	//Driver Code
	public static void main(String[] args) {
		int R = 4;
		int C = 4;
		
		int[][] A = {
				{0, 1, 1, 0},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 0, 0},
		};
		
		System.out.print("Area of maximum rectangle is " + maxRectangle(R, C, A));
	}

}
