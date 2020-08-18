package patternsByloops;

public class Pattern8 
{
	public static void main(String[] args) 
	{
		int size = 3;								//size of pattern
		
		for(int i=size;i>=-size;i--) {				//loop for handling spaces & stars
			
			for(int j=1;j<=Math.abs(i);j++) 		//inner or nested loop to handle or print spaces
				System.out.print(" ");				//printing the spaces
		
			for(int k=size;k>=Math.abs(i);k--)		//inner or nested loop to handle or print stars 
				System.out.print("*");				//printing the stars
			
			System.out.println();					//for new line
		}//end of loop

	}//end of main
}//end of class
