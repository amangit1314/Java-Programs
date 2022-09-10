package trees.binaryTree;

/*	
 * Problem Title :- In-order Traversal of a tree using Recursion
 */
public class BT_Problem_06_b {

	Node root;
	
	// Constructor
	BT_Problem_06_b(){
		root = null;
	}
		
	//Given a binary tree, print its nodes in in-order
	void printInorder(Node node) {
			
		if(node == null)	return;
			
		/* first recur on left child */
		printInorder(node.left);
			
		/* then print data of node */
		System.out.print(node.data + " ");
			
		/* now recur on right child */
		printInorder(node.right);
	}
		
	// Wrappers over above recursive function
	void printInorder() { printInorder(root); }
		
		
	// Driver method
	public static void main(String[] args) {

		BT_Problem_06_b tree = new BT_Problem_06_b();
			
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
			
		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();	
	}
}
