package sdeProblems;

public class FindDuplicate {
	
			// Implementing an array as a HashMap for finding duplicate elements	
			void printRepeating(int m[],int size) {
				
				int i;
				System.out.print("The repeating elements are:");
				
				for(i=0;i<size;i++) {
					
					// using Math.abs() function to find the duplicate element in HashMap.
					
					if(m[Math.abs(m[i])]>=0)	m[Math.abs(m[i])] = -m[Math.abs(m[i])];
					else						System.out.print(Math.abs(m[i]) + " ");
				}
			}
			
			//Driver Method
			public static void main(String[] args) {
				
				FindDuplicate duplicate = new FindDuplicate();			// Making an object of FindDuplicate class
				
				int m[] = {1,2,3,1,3,6,6};								// Putting or declare values in or to array
				int m_size = m.length;									// variables which store size or length of array
				
				duplicate.printRepeating(m,m_size);						// calling above function to pass value in it to print repeating elements
				
			}
			
	}
