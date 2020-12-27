package patternsByloops;

public class Pattern5 {

	public static void main(String[] args) {
		
		int min_stars =0;								/*change value to set minimum no. of stars in pyramid 
														take odd no.for odd no. of stars in each row 1-3-5 
														etc 
														take even no. for even no. stars in each row,2-4-6 etc */
		
		int p_height=6;									//change value to increase or decrease the size of pyramid 		
		
		int p_space = p_height - 1;
		
		for(int i= 1;i<p_height;i++) 
		{
			
			for(int j=p_space;j>i;j--)
				System.out.print(" ");
			
			for(int k=0;k<=min_stars;k++)
				System.out.print("* ");	
		
			min_stars+=2;
			System.out.println();	
		}
		
	}//end of main
}//end of class
