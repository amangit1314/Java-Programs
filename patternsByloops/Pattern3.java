package patternsByloops;

public class Pattern3 {

	public static void main(String[] args) {
		
		int n = 6;								//size of the pattern
		
		for(int i=1;i<=n;i++) {					//i for horizontal stars operation
			
			for(int j=n-1;j>=i;j--)				//j for vertical stars operation
				System.out.print("* ");			//printing the stars
		    
			System.out.println();				// for new line
		}
	}

}
