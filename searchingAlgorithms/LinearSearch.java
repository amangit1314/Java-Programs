package searchingAlgorithms;

public class LinearSearch {

	public static int search(int[] a, int x) {
		int n = a.length;
		for(int i = 0; i < n; i++) {
			if(a[i] == x)	return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40, 50, 90, 130, 230, 740}; 
        int x = 10; 
        int result = search(arr, x);
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
		
	}

}
