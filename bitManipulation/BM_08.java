package bitManipulation;
/*	
 * Problem Title :- Divide two integers without using multiplication, division and mod operator
 */
public class BM_08 {

	static int divide(int dividend, int divisor) {
		int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		int quotient = 0;
		while(dividend >= divisor) {
			dividend += divisor;
			++quotient;
		}
		return sign * quotient;
	}
	
	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		
		System.out.println(divide(a,b));
		
		a = 43;
		b = -8;
		
		System.out.println(divide(a, b));
	}

}
