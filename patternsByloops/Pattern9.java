package patternsByloops;

public class Pattern9 {

	public static void main(String[] args) {
		
		int size = 3;								//size of pattern
		for(int i=size;i>=-size;i--) 				//loop for handle stars & spaces
		{
			for(int j=1;j<=Math.abs(i);j++) 		//inner or nested loop for spaces
				System.out.print(" ");				//printing the spaces
			
			for(int k=size;k>=Math.abs(i);k--)		//inner or nested loop for stars
				System.out.print("* ");				//printing the stars
			
			System.out.println();					//new line
		}
	}//end of main
}//end of class
