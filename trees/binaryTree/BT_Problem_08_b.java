package trees.binaryTree;

public class BT_Problem_08_b {

	// Root of Binary Tree
	Node root;
			
	// Constructor
	BT_Problem_08_b(){
		root = null;
	}
			
	// Given a binary tree, print its nodes according to the "bottom-up" post-order traversal. 
	void printPostorder(Node node) {
		//base case
		if(node == null)
			return;
		// first recur on left subtree
		printPostorder(node.left);
				
		// then recur on right subtree
		printPostorder(node.right);
				
		// now deal with the node
		System.out.print(node.data + " ");
	}
	
	// Wrapper over above recursive function
	void printPostorder() { 
		printPostorder(root);
	}
	
	//Driver Code
	public static void main(String[] args) {
		BT_Problem_08_b tree = new BT_Problem_08_b();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();
	}

}
