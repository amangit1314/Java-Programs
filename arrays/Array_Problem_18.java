package arrays;

/* Problem Title :->   find all pairs on integer arrays.array whose sum is equal to given number     OR	 Equal_Sum_Pairs_of_Array */
public class Array_Problem_18 {

	//function to find & print the sum & elements
	static void pairs_value(int[] iA, int iN) {
		System.out.println("Pairs of elements & their sum : ");
		
		//loop to iterate & find the pair of elements whose sum is equal
		for(int i = 0 ; i < iA.length ; i++) {
			for(int j = i + 1 ; j < iA.length ; j++) 
				//check if the sum of pair is equal, if equal then print the pair of elements & their sum
				if(iA[i]+iA[j] == iN)	System.out.println(iA[i] + " + " + iA[j] + " = " + iN);
		}
	}
	
	//Driver Method
	public static void main(String[] args) {
		pairs_value(new int[] {2,7,4,-5,11,5,20}, 15);
		pairs_value(new int[] {14,-15,9,16,25,45,12,8},30);
	}

}
