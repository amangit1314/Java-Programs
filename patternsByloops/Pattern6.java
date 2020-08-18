package patternsByloops;

public class Pattern6 {

	public static void main(String[] args) 
	{
		int n=5;	
		//size of pattern
		for(int i= n;i>=1;i--) 
		{
			for(int j=n-1;j>=i;j--) 					// loop for print the spaces
				System.out.print(" ");					//printing the spaces
			
			for(int k =1;k<=i;k++) 						// loop for print the stars
				System.out.print("*");					//printing the stars
			
			System.out.println();						//for new line
		}//end of loop
		
	}//end of main
}//end of class
