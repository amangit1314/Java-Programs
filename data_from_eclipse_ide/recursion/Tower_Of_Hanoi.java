package recursion;

/*
 * Stack Application :- Tower of Hanoi Problem(Puzzle 1)
 */
public class Tower_Of_Hanoi {

	//function to solve the tower of hanoi proble
	static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
		
		if(n == 1) {
			System.out.println("Move disk 1 from rod " + from_rod + " to_rod " + to_rod);
			return;
		}
		
		towerOfHanoi(n-1, from_rod, to_rod, aux_rod);
		System.out.println("Move disk "+ n +" from_rod "+from_rod+" to rod "+to_rod);
		
	}
	
	//Driver Method
	public static void main(String[] args) {
		
		int n =4;
		towerOfHanoi(n,'A','C','B');
		
	}

}
