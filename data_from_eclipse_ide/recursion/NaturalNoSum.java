package recursion;

/*
 * Find sum of first N natural numbers using recursion 
 */
public class NaturalNoSum {

	public static void main(String[] args) {
		System.out.println(sum(5));
	}
	
	static int sum(int N) {
		//Base case
		if(N == 1)		return 1;
		
		//Recursive call
		return N+sum(N-1)  ;
	}

}
