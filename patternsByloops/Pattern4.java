package patternsByloops;

public class Pattern4 {
	public static void main(String[] args) {
		
		int n=6;								//size of the pattern
		
		for(int i=n;i>=1;i--){					//i for horizontal stars
			
			for(int j=n-1;j>=i;j--)				//j for vertical and for print & handling the spaces
				System.out.print(" ");
			
			for(int k=1;k<=i;k++)				//k variable for print the values
				System.out.print("* ");			//printing the stars
			
			System.out.println();
		}
	}

}
