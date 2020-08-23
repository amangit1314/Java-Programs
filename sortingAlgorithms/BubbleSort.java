package sortingAlgorithms;

public class BubbleSort {

	public static void main(String[] args) {
		
		int a[] = {7,9,-4,6,8,5};
		int n = a.length;
		
		for(int i=0;i<=n-1-i;i++) {
			for(int j=0;j<=n-1-i;j++) {
				
				boolean sorted = true;
				
				if(a[j+1] < a[j]){
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j]= temp;
					sorted = false;
				}
					
				if(sorted) break;
			}	
		}
		
		for(int item:a) 
			System.out.print(item+" ");

	}//end of main
}//end of class
