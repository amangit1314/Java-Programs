package linkedList;

public class Insertion_in_Linked_List {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	Node head;
	
	public void push(int new_data ) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	public void insertAfter(Node prev_node, int new_data) 
    { 
        /* 1. Check if the given Node is null */
        if (prev_node == null) 
        { 
            System.out.println("The given previous node cannot be null"); 
            return; 
        } 
  
        /* 2 & 3: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next; 
  
        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node; 
    } 
	
	public void append(int new_data) {
		
		//make an object of above mentioned Node class 
		Node new_node = new Node(new_data);
		
		if(head == null) {
			head = new_node;
			return;
		}
		
		new_node.next = null;
		
		Node last = head;
		while (last.next != null) 
            last = last.next;
		
		last.next = new_node;
		return;	
	}
	
	public void printList() 
    { 
        Node tnode = head; 
        while (tnode != null) 
        { 
            System.out.print(tnode.data+" "); 
            tnode = tnode.next; 
        } 
    } 
	
	public static void main(String[] args) {
		Insertion_in_Linked_List llist = new Insertion_in_Linked_List();
		/* Start with the empty linkedList.list */
  
        // Insert 6.  So linked linkedList.list becomes 6->NUllist
        llist.append(6); 
  
        // Insert 7 at the beginning. So linked linkedList.list becomes
        // 7->6->NUllist 
        llist.push(7); 
  
        // Insert 1 at the beginning. So linked linkedList.list becomes
        // 1->7->6->NUllist 
        llist.push(1); 
  
        // Insert 4 at the end. So linked linkedList.list becomes
        // 1->7->6->4->NUllist 
        llist.append(4); 
  
        // Insert 8, after 7. So linked linkedList.list becomes
        // 1->7->8->6->4->NUllist 
        llist.insertAfter(llist.head.next, 8); 
  
        System.out.println("\nCreated Linked linkedList.list is: ");
        llist.printList(); 
	}

}
