package arrays;
/* Problem Title :-> Find the triplet that sum to a given value
 */
public class Array_Problem_29 {
	boolean find3Numbers(int[] A, int a_size, int sum) {
		int l, r;
		for(int i = 0; i < a_size - 2; i++) {
			for(int j = i + 1; j < a_size - 1; j++) {
				for(int k = j + 1; k < a_size; k++) {
					if(A[i] + A[j] + A[k] == sum) {
						System.out.println("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Array_Problem_29 triplet = new Array_Problem_29();
		int[] A = {1, 4, 45, 6, 10, 8};
		int sum = 22;
		int a_size = A.length;
		triplet.find3Numbers(A, a_size, sum);
	}
}
