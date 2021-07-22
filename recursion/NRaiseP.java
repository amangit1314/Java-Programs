package recursion;

public class NRaiseP {

	public static int nRaisep(int n, int p) {
		if(p == 0)
			return 1;
		return n*nRaisep(n,p-1);
	}
	
	public static void main(String[] args) {
		System.out.println(nRaisep(3,4));
	}

}
