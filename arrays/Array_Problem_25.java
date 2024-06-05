package arrays;
/* Problem Title :-> Given an arrays.array of size n and a number k, fin all elements that appear more than " n/k " times.
 */
import java.util.*;

class Array_Problem_25 {

	static class eleCount{
		int element, count;
	}

	static void moreThanNdk(int[] a, int n, int k) {

		if(k < 2)	return;

		eleCount[] temp = new eleCount[k-1];

		for(int i = 0; i < k-1; i++) {
			temp[i] = new eleCount();
		}

		for(int i = 0; i < k-1; i++) {
			temp[i].count = 0;
		}

		for(int i = 0; i < n; i++) {

			int j;

			for(j = 0; j < k - 1; j++) {
				if(temp[j].element == a[i]) {
					temp[j].count += 1;
					break;
				}
			}

			if(j == k - 1) {
				int l;
				for(l = 0; l < k - 1; l++) {
					if(temp[1].count == 0) {
						temp[l].element = a[i];
						temp[l].count = 1;
						break;
					}
				}

				if(l == k - 1)
					for(l = 0; l < k-1; l++)
						temp[l].count -= 1;
			}
		}
			for(int i = 0; i < k -1; i++) {

			int ac = 0;

			for(int j = 0; j < n; j++) {
				if(a[j] == temp[i].element)
					ac++;
			}

			if(ac > n/k)
				System.out.println("Number:" + temp[i].element + " Count:" + ac + "\n");
		}
	}

	// Driver Code
	public static void main(String[] args) {

		System.out.println("First Test\n");
		int[] a1 = {4,5,6,7,8,4,4};
		int size = a1.length;
		int k = 3;
		moreThanNdk(a1, size, k);

		System.out.println("\nSecond Test\n");
		int[] a2 = {4,5,6,7,8,4,4};
		size = a2.length;
		k = 3;
		moreThanNdk(a2, size, k);

		System.out.println("\nThird Test\n");
		int[] a3 = {4,5,6,7,8,4,4};
		size = a3.length;
		k = 3;
		moreThanNdk(a3, size, k);

		System.out.println("\nFourth Test\n");
		int[] a4 = {4,5,6,7,8,4,4};
		size = a4.length;
		k = 3;
		moreThanNdk(a4, size, k);
	}
}
