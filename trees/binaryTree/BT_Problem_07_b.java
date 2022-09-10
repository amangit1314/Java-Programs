package trees.binaryTree;

/*	
 * Problem Title :- Pre-order Traversal of a tree using Recursion
 */
public class BT_Problem_07_b {
	// Root of Binary Tree
	Node root;
			
	// Constructor
	BT_Problem_07_b(){
		root = null;
	}

	/*
	 * Given a binary tree,
	 * print its nodes in preorder
	 */
	void printPreorder(Node node) {
		
		if(node == null)	return;
		
		/* first print data of node */
		System.out.print(node.data + " ");
		
		/* then recur on left subtree */
		printPreorder(node.left);
		
		/* now recur on right subtree */
		printPreorder(node.right);
	}
	
	// Wrappers over above recursive function
	void printPreorder() {
		printPreorder(root); 
	}
	
	//Driver Code
	public static void main(String[] args) {
		BT_Problem_07_b tree = new BT_Problem_07_b();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();
	}

}
