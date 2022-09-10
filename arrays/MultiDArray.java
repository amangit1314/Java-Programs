package arrays;

//Intro to multidimensional arrays.array
public class MultiDArray {
	
	public static void main(String args[]) {
		
		int arr[][] = { {2,7,9} , {3,6,1} , {7,4,2} };
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) 
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}
