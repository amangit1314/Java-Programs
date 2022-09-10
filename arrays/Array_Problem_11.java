package arrays;

/*
 * find duplicate in an arrays.array of N+1 Integers
 */
public class Array_Problem_11 {
	
	// Implementing an arrays.array as a HashMap for finding duplicate elements
	void printRepeating(int m[],int size) {		
		int i;
		System.out.print("The repeating elements are: ");
					
		for(i = 0 ; i < size ; i++) {		
		// using Math.abs() function to find the duplicate element in HashMap.		
			if(m[Math.abs(m[i])]>=0)	m[Math.abs(m[i])] = -m[Math.abs(m[i])];
			else						System.out.print(Math.abs(m[i]) + " ");
		}
	}
				
	//Driver Method
	public static void main(String[] args) {
		
		Array_Problem_11 dublicate= new Array_Problem_11();	
		
		int m[] = {1,2,3,1,3,6,6};	
		int m_size = m.length;
		
		dublicate.printRepeating(m,m_size);						
					
	}

}

