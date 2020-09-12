package sortingAlgorithms;

public class BubbleSort {
	
	void bubbleSort(int a[]) {
	
		int n = a.length;
		for(int i=0;i<n-1;i++) 
		{
			for(int j=0;j<n-i-1;j++) 
			{
				if(a[j]>a[j+1]) {
				//swap a[j+1] and a[i]
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	//function to print the array
	void printArray(int a[]) {
		
		int n = a.length;
		for(int i=0;i<n;++i)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	//Driver method to test above
	public static void main(String[] args) {
		
		BubbleSort ob = new BubbleSort();
		int a[] = {1,5,7,9,8,6,4,2};
		ob.bubbleSort(a);
		System.out.println("Sorted Array");
		ob.printArray(a);
	}
}
	
		
