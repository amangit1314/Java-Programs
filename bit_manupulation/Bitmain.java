package bit_manupulation;

public class Bitmain {
	
	static boolean getBit(int n , int pos) {
		return ((n & (1 << pos))!=0);
	}

	public static int main(String[] args) {
		System.out.println(getBit(5,2));
		return 0;
	}
}
