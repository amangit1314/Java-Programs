package basic_idea_of_DS;
import java.util.LinkedList;
public class LinkedListDemo {

	public static void main(String[] args) {
		// Create a linked linkedList.list
		LinkedList<String> ll = new LinkedList<>();
		
		// Add elements to the linked linkedList.list
		ll.add("A");
		ll.add("M");
		ll.add("M");
		ll.add("N");
		ll.add("S");
		ll.addFirst("S1");
		ll.addLast("S2");
		ll.add(1,"A1");
		System.out.println("Original contents of ll:"+ll);
		
		//Remove elements from the linked linkedList.list
		ll.remove("A1");
		System.out.println("Content of ll after deletion:"+ll);
		
		//Remove first & last elements
		ll.removeFirst();
		ll.removeLast();
		System.out.println("ll after deleting first & last:" + ll);
		
		//Get & set value
		String val = ll.get(2);
		ll.set(2, val + "Changed");
		System.out.println("ll after change:"+ll);
	}

}
