package patternsByloops;

// Program for pattern 1
public class Pattern1 {

	// Driver Function
	public static void main(String[] args) {
		int n = 6;
		// i's for row's
		for(int i = 0; i < n; i++) {
			// j's for column's
			for(int j = 0; j < i; j++)
				System.out.print("*");
			// print the next line
			System.out.println();
		}
	}
}
