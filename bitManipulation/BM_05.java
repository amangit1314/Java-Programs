package bitManipulation;
/*	
 * Problem Title :- Program to find whether a no is power of two
 */
public class BM_05 {

	static boolean isPowerOf2(int n) {
		if(n==0)
			return false;
	 
		return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==
	       (int)(Math.floor(((Math.log(n) / Math.log(2)))));
	}
	
	public static void main(String[] args) {
		
		if(isPowerOf2(31))	System.out.println("Yes");
		else	System.out.println("No");
		     
		if(isPowerOf2(64))	System.out.println("Yes");
		else	System.out.println("No");
	}

}
