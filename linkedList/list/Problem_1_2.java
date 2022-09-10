package linkedList.list;

/*
 * Write a Program to Reverse the LinkedList Recursively
 */

public class Problem_1_2 {

	static Node head;
	
	static class Node{
		int data;
		Node next;
		// Constructor
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	static Node reverse(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node rest = reverse(head.next);
		head.next.next = head;
		
		
		head.next = null;
		
		return rest;
	}
	
	
	static void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	static void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}
	
	public static void main(String[] args) {
		
		push(20);
		push(4);
		push(15);
		push(85);
		
		System.out.println("Given linked linkedList.list");
		print();
		
		head = reverse(head);
		
		System.out.println("Reversed Linked linkedList.list");
		print();
		
	}

}
