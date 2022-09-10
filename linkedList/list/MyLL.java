package linkedList.list;

public class MyLL<E> {
	//E is the Class defining the type of the inputs accepted
	Node<E> head;

	public void add(E data) {
		Node<E> toAdd = new Node<>(data);

		if (isEmpty()) {
			head = toAdd;
			return;
		}

		//initialising temp as head to traverse the Linked linkedList.list without breaking the chain
		Node<E> temp = head;

		// control from loop exits as soon as next element becomes null
		while (temp.next != null)
			temp = temp.next;

		// adding the new node after reaching to the end of linked linkedList.list
		temp.next = toAdd;
	}

	void print() {
		Node<E> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public E removeLast() throws Exception {
		Node<E> temp = head;

		if (temp == null) {
			throw new Exception("Cannot remove last element from empty linked linkedList.list");
		}

		if (temp.next == null) {
			Node<E> toRemove = head;
			head = null;
			return toRemove.data;
		}

		while (temp.next.next != null) {
			temp = temp.next;
		}
		Node<E> toRemove = temp.next;
		temp.next = null; // changing the pointer of temp.next from toRemove to null,
		// and garbage collection is done automatically
		return toRemove.data;
	}

	public E getLast() throws Exception {
		Node<E> temp = head;

		if (temp == null) {
			throw new Exception("Cannot peek last element from empty linked linkedList.list");
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}

	public static class Node<E> {
		public E data;
		public Node<E> next;

		// Empty Constructor
		public Node() {}

		// parameterized constructor
		public Node(E data) {
			this.data = data;
			next = null;
		}

		// multi parameterized constructor
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
}