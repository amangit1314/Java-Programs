package bitManipulation;
/*	
 * Problem Title :- Find position of the only set bit
 */
public class BM_06 {

	static boolean isPowerOf2(int n) {
		return(n > 0 && ((n & (n-1)) == 0)) ? true: false;
	}
	
	static int findPosition(int n) {
		if(!isPowerOf2(n))	return -1;
		int i = 1, pos = 1;
		while((i & n)==0) {
			i = i << 1;
			++pos;
		}
		return pos;
	}
	
	public static void main(String[] args) {
		int n = 16;
		int pos  = findPosition(n);
		if(pos == -1)	System.out.println("n = "+ n + ", Invalid number");
		else	System.out.println("n = " + n + ", Position " + pos);
		n = 12;
		pos  = findPosition(n);
		if(pos == -1)	System.out.println("n = "+ n + ", Invalid number");
		else	System.out.println("n = " + n + ", Position " + pos);
		n = 128;
		pos  = findPosition(n);
		if(pos == -1)	System.out.println("n = "+ n + ", Invalid number");
		else	System.out.println("n = " + n + ", Position " + pos);
		
	}

}
