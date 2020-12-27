package patternsByloops;

public class Pattern5_2 {
	
	public static void main(String[] args) {
		
		int n = 5;												//size of pattern
		
		int px =n;												//left print control
		int py =n;												//right print control
		
		for(int i=1;i<=n;i++) 									//i for horizontal stars
		{														
			for(int j=1;j<n*2;j++) 								//j for vertical stars
				if(j>=px && j<=py)	System.out.print("* ");		//if condition is true then print the stars
				else				System.out.print(" ");		//else print the spaces
				
			px--;												//post decrementing the left print control
			py++;												//post incrementing the right print control
			System.out.println();
		}

	}
}
