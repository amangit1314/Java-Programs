package patternsByloops;

public class Pattern7 
{
	public static void main(String[] args) 
	{
		
		int size = 3;								//size of the pattern
		
		for(int i=size;i>=-size;i--)				//loop to print the stars
		{
			for( int j=size;j>=Math.abs(i);j--) 	//inner or nested loop for print the stars
				System.out.print("* ");
			
			System.out.println();					//for new line
		}//end of loop
	}//end of main
}//end of class
