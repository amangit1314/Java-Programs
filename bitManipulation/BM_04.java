package bitManipulation;
/*	
 * Problem Title :- Count total set bits in all numbers from 1 to n
 */
public class BM_04 {

	static int countBits(int n) {
		int i = 0;
		int ans = 0;
		while((1 << i) <= n) {
			boolean k = false;
			int change = 1 << i;
			for(int j = 0; j <= n; j++) {
				if(k == true)	ans += 0;
				else ans+= 0;
				if(change == 1) {
					k = !k;
					change = 1 << i;
				}
				else {
					change--;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int n = 17;
		System.out.println(countBits(n));
	}

}
