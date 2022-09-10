package arrays.array;
import java.util.*;

//Language: Java
//Time Complexity: O(n)3 Linear traversals.
//Space Complexity: O(n) Array of candies.

public class Candy_Distribution_Problem{
	
	public int candy(int[] ratings) {
		   if (ratings.length < 2) 
		     return ratings.length;
		   
		     
		   int[] candies = new int[ratings.length];
		   Arrays.fill(candies, 1);
		     
		   // ** Step 1: Forward **
		   for (int i=0; i<ratings.length-1; i++) {
		     if (ratings[i] >= ratings[i+1]) {
		       continue;
		     }         
		     candies[i+1] = candies[i] + 1;    
		   }
		     
		   // ** Step 2: Backward **
		   for (int i=ratings.length-1; i>0; i--) {
		     if (ratings[i] >= ratings[i-1]) {
		       continue;
		     }
		     candies[i-1] = Math.max(candies[i] + 1, candies[i-1]);   
		   }
		     
		   // ** Step 3: Count Candies **
		   int count = 0;
		   for (int i=0; i<candies.length; i++) {
		     count += candies[i];
		   }
		     
		   return count;     
		}
	
	public static void main(String[] args) {
		int[] ratings = {12 , 34 , 45 , 67 , 43 , 75};
	}
	
}

