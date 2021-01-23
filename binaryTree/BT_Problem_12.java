package binaryTree;
import java.util.*;

/*	
 * Problem Title :- Write a Java program to find Bottom View of Tree. 
 */
public class BT_Problem_12 {

	Node root;
	
	public BT_Problem_12() {}
	
	public BT_Problem_12(Node node){
		root = node;
	}
	
	private void BottomView() {
		
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
	}
	
	
	public static void main(String[] args) {
		
	}

}
