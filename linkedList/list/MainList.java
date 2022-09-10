package linkedList.list;

public class MainList {

	public static void main(String[] args) {

		MyLL<String> myLL = new MyLL<>();

		for (int i = 0; i < 10; i++) {
			// add method use to add a element in the last node of the linked linkedList.list
			myLL.add(i + "added");

		}
// print method use to print the linked linkedList.list
		myLL.print();
	}

}
