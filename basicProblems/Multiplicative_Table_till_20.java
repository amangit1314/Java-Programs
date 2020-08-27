package basicProblems;

public class Multiplicative_Table_till_20 {

	public static void main(String[] args) {
		
		for(int i=1;i<=20;i++) {
			
			int tableOf = i;
			
			for(int j =1;j<=10;j++) {
				System.out.print(tableOf*i + " ");
			}
			
			System.out.println();
		}

	}

}
