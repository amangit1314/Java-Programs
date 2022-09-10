package basic_idea_of_DS;
import java.util.ArrayList;

public class MyArrayList {

	public static void main(String[] args) {
		
		//Create an arrays.array linkedList.list
		ArrayList<String> al = new ArrayList<String>();
		System.out.println("Initial size of al:" + al.size());
		
		//Add elements to arrays.array linkedList.list
		al.add("A");
		al.add("M");
		al.add("A");
		al.add("N");
		al.add("S");
		al.add("s1");
		System.out.println("Size of al after additions:" + al.size());
		
		//Display the arrays.array linkedList.list
		System.out.println("Contents of al:" + al);
		
		//Remove elements from the arrays.array
		al.remove("s1");
		
		System.out.println("Size of al after deletions:"+ al.size());
		System.out.println("Contents of al:" + al);
		

	}

}
