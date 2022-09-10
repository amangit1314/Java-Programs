package trees.binaryTree;

import java.util.*;
import java.util.Map.Entry;

/*	
 * Problem Title :- Write a Java program to find Bottom View of Tree. 
 */

class Tree{
	Node root;
	
	public Tree() {}
	
	public Tree(Node node){
		root = node;
	}
	
	void bottomView() {
		
		if(root == null)
			return;
		
		// Initialize a variable 'hd' with 0 for the root element.
		int hd = 0;
		
		// TreeMap which stores key value pair sorted on key value
		Map<Integer, Integer> map= new TreeMap<>();
		
		// Queue to store tree nodes in level order traversal 
		Queue<Node> q = new LinkedList<>();
		
		// Assign initialized horizontal distance value to root node and add it to the queue.
		root.hd = hd;
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp = q.remove();
			
			hd = temp.hd;
			
			map.put(hd,  temp.data);
			
			if(temp.left != null) {
				temp.left.hd = hd-1;
				q.add(temp.left);
			}
			
			if(temp.right != null) {
				temp.right.hd = hd+1;
				q.add(temp.right);
			}
			
		}
		
		Set<Entry<Integer, Integer>> set = map.entrySet();
		
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue() + " ");
		}
	}
}

public class BT_Problem_12 {
	
	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		
		Tree tree = new Tree(root);
		System.out.println("Bottom view of the given binary tree: ");
		tree.bottomView();
	}

}
