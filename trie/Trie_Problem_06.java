package trie;
/*
 * Problem Title :-Find shortest unique prefix for every word in a given linkedList.list
 */
public class Trie_Problem_06 {

	static int ROW = 4;
	static int COL = 5;
	 
	// Function that prints all
	// unique rows in a given matrix.
	static void findUniqueRows(int M[][])
	{
	     
	    // Traverse through the matrix
	    for(int i = 0; i < ROW; i++)
	    {
	        int flag = 0;
	         
	        // Check if there is similar column
	        // is already printed, i.e if i and
	        // jth column match.
	        for(int j = 0; j < i; j++)
	        {
	            flag = 1;
	 
	            for(int k = 0; k < COL; k++)
	                if (M[i][k] != M[j][k])
	                    flag = 0;
	 
	            if (flag == 1)
	                break;
	        }
	 
	        // If no row is similar
	        if (flag == 0)
	        {
	             
	            // Print the row
	            for(int j = 0; j < COL; j++)
	                System.out.print(M[i][j] + " ");
	 
	            System.out.println();
	        }
	    }
	}
	 
	// Driver Code
	public static void main(String[] args)
	{
	    int M[][] = { { 0, 1, 0, 0, 1 },
	                  { 1, 0, 1, 1, 0 },
	                  { 0, 1, 0, 0, 1 },
	                  { 1, 0, 1, 0, 0 } };
	 
	    findUniqueRows(M);
	}

}
