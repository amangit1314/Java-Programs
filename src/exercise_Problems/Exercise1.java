package exercise_Problems;
import java.util.*;

/* To calculate percentage of a given student in CBSE Board exam.
 * His marks from 5 subjects must be taken as input from the keyboard
 * (Marks are out of 100)
 * */

public class Exercise1 {
	
	static Scanner sc = new Scanner(System.in);
	
	static int subject_1_marks = sc.nextInt();
	static int subject_2_marks = sc.nextInt();
	static int subject_3_marks = sc.nextInt();
	static int subject_4_marks = sc.nextInt();
	static int subject_5_marks = sc.nextInt();
	
	public static void main(String[] args) {
		
		int total = (subject_1_marks + subject_2_marks + subject_3_marks + subject_4_marks + subject_5_marks);
		float percentage = (total)/5;
		
		System.out.println("The marks of the subject's are: \n " + "\n" + "subject_1_marks:- " + subject_1_marks + "\n" + 
				"subject_2_marks:- " + subject_2_marks + "\n" + "subject_3_marks:- " + subject_3_marks + "\n" + 
				"subject_4_marks:- " + subject_4_marks + "\n" + "subject_5_marks:- " + subject_5_marks + "\n");

		System.out.println("The total no. of marks are: " + total);
		System.out.println("Total percentage is: " + percentage);
	
	}

}
