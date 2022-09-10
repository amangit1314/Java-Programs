package trees.binaryTree;
import java.util.*;
import java.util.Map.Entry;

/*	
 * Problem Title :- Write a Java program to find Top View of Tree. 
 */
// Class of binary Tree
public class BT_Problem_11 {

	Node root;
	
	public BT_Problem_11() {
		root = null;
	}
	
	// function should print the topView of the binary tree
	private void TopView(Node root) {
		class QueueObj{
			Node node;
			int hd;
			QueueObj(Node node, int hd){
				this.node = node;
				this.hd = hd;
			}
		}
		
		Queue<QueueObj> q = new LinkedList<>();
		Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();
		
		if(root == null)
			return;
		else
			q.add(new QueueObj(root, 0));
		
		System.out.println("The top view of the tree is : ");
		
		/* count function returns 1 if the container
		 * contains an element whose key is equivalent to hd,
		 * or returns zero otherwise. */
		while(!q.isEmpty()) {
			QueueObj tempNode = q.poll();
			
			if(!topViewMap.containsKey(tempNode.hd)) 
				topViewMap.put(tempNode.hd, tempNode.node);
			
			if(tempNode.node.left != null)
				q.add(new QueueObj(tempNode.node.left, tempNode.hd + 1));
			
			if(tempNode.node.left != null)
				q.add(new QueueObj(tempNode.node.left, tempNode.hd + 1));
		}
		
		for(Entry<Integer, Node> entry : topViewMap.entrySet())
			System.out.print(entry.getValue().data);
	}
	
	// Driver Program to test & run above functions
	public static void main(String[] args) {

		BT_Problem_11 tree = new BT_Problem_11();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(4);
		tree.root.left.right.right.right = new Node(4);
		
		System.out.println("Following are nodes in top view of Binary Tree");
		tree.TopView(tree.root);
		
	}

}
