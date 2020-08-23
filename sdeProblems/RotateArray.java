package sdeProblems;

public class RotateArray {
	
		//function to rotate the elements of an array
	
		void rotateL(int a[], int d, int n) {
			for(int i= 0;i<d;i++) 
				rotateLByOne(a,n);
		}
		
		// rotate the array by left by one
		
		void rotateLByOne(int a[],int n) {
			int i,temp;
			temp = a[0];
			for(i =0;i<n-1;i++)
				a[i] = a[i+1];
			a[i] = temp;
		} 
		
		// a utility function to display the elements  of array
		
		void printArray(int a[],int n) {
			for(int i=0;i<n;i++) 
				System.out.print(a[i]+" ");	
		}
		
		// driver method of the program
		public static void main(String[] args) {
			
			RotateArray rotate = new RotateArray();
			
			int a[] = {2,4,6,8,10,12,14,16,18,20};
			rotate.rotateL(a, 3, 10);
			rotate.printArray(a , 10);
		}
}
