package bitManipulation;
/*	
 * Problem Title :- Copy set bits in a range
 */
public class BM_07 {

	static int setAllBitsOfGivenRange(int n, int l, int r) {
		int range = (((1 << (l - 1)) - 1) ^ ((l << (r)) - 1));
		return (n | range);
	}
	
	public static void main(String[] args) {
		int n = 17, l = 2, r = 3;
		System.out.println(setAllBitsOfGivenRange(n,l,r));
	}

}
