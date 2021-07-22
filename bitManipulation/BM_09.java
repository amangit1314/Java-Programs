package bitManipulation;
/*	
 * Problem Title :- Calculate square of a number without using *, / and pow()
 */
public class BM_09 {

	public static int square(int n) {
		if(n < 0)	n = -n;
		int res = n;
		for(int i = 1; i < n; i++)	res += n;
		return res;
	}
	public static void main(String[] args) {
		for(int n = 1; n <= 5; n++)
			System.out.println("n =" + n + ", n^2 = " + square(n));
	}

}
