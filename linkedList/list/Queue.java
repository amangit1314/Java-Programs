package linkedList.list;
import java.util.*;

/*
 * 	Code: Queue Using LL
 * 
 * 	Send Feedback:
 * 	You need to implement a Queue class using linked linkedList.list.
 * 	All the required data members should be private.
 * 
 *  Implement the following public functions:
 *  1. Constructor - Initialise's the data members.
 *  2. enqueue - This function should take one argument of type T and has return type void.
 *  			 This function should insert an element in the queue. 
 *  			 Time complexity should be O(1).
 *  3. dequeue - This function takes no arguments and has return type T.
 *  			 This should removes the first element which is entered and return that element as an answer.
 *  			 Time complexity should be O(1).
 *  4. front -   This function takes no input arguments and has return type T.
 *  			 This should return the first element which is entered and return that element as an answer.
 *  			 Time complexity should be O(1).
 *  5. size -    Return the size of stack i.e. count of elements which are present ins stack right now.
 *  			 Time complexity should be O(1).
 *  6. isEmpty - Checks if the queue is empty or not. 
 *  			 Return true or false
 *  
 */

class QueueEmptyException extends Exception {

	private static final long serialVersionUID = 7243921724361015813L;

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		Queue<Integer> st = new Queue<Integer>();

		int choice = s.nextInt();
		int input;

		while (choice !=-1) {
			
			if(choice == 1) {
				input = s.nextInt();
				st.enqueue(input);
			}
			
			else if(choice == 2) {
				
				try {
					System.out.println(st.dequeue());
				}catch (QueueEmptyException e) {
					System.out.println(-1);
				}
			}
			
			else if(choice == 3) {
				
				try {
					System.out.println(st.front());
				} catch (QueueEmptyException e) {
					System.out.println(-1);
				}
			}
			
			else if(choice == 4) 
				System.out.println(st.size());
			
			else if(choice == 5) 
				System.out.println(st.isEmpty());
			
			choice = s.nextInt();
		}
	}
}

class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
}

public class Queue<T> {
 
	private Node<T> front;
 	private Node<T> rear;
 	private int size;
 

	public Queue() {
     front=null;
     rear=null;
     size=0;

	}

	public int size() {
		return size;
	}
		
	public boolean isEmpty() {
		return (size==0);
	}
		
	public T front() throws QueueEmptyException {
		
		if(size==0)
         	throw new QueueEmptyException();
		
		return front.data;   
	}    
 
	public void enqueue(T data) {
		
		if(size==0){
			Node<T> newnode=new Node<T>(data);  
			front=newnode;
			rear=newnode;
			size++;
		}
		
		else{     	
  			Node<T> newnode=new Node<T>(data);
  			rear.next=newnode;
  			rear=rear.next;
  			size++;
         }
	}


	public T dequeue() throws QueueEmptyException {
		
		if(size==0)
         	throw new QueueEmptyException();
     
		if(size==1){
			T temp=front.data;
			front=null;
			rear=null;
			size=0; 
			return temp;
		}
     
		else{ 
			T temp = front.data;
			front = front.next;
			size--;
			return temp;  
		}
	}

}