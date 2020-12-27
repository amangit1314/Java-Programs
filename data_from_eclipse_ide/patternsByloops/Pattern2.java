package patternsByloops;
public class Pattern2 {

	public static void main(String[] args) {
		
		int w = 5;			//size of the pattern
		
		for(int i=1;i<=w;i++){				//i for vertical Stars
			
			for(int j=w;j>=i;j--)			//j for horizontal stars
				System.out.print("* ");		//printing the stars
			
			System.out.println();
		}
	}

}
