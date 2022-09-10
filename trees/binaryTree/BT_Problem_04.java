package trees.binaryTree;
/*	Problem Title :- Find the Diameter of a tree or Width of tree.
 * 
 *  Diameter of a tree :- 
 *  The Diameter of a tree is the number of nodes on the longest path
 *  between two end nodes.
 */

// Class to print the Diameter.
public class BT_Problem_04 {

	Node root;
	
	// Method to calculate the diameter and return it to main
	int diameter(Node root) {
		// base case if tree is empty
		if(root == null)
			return 0;
		
		// get the height of left and right sub-trees
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		// get the diameter of left and right sub-trees
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}
	
	// A wrapper over diameter(Node root)
	int diameter() {return diameter(root);}
	
	/*
	 * The function Compute the "height" of a tree.
	 * Height is the number of nodes along the longest path 
	 * from the root node to the farthest leaf node.
	 */
	static int height(Node node) {
		if(node == null)
			return 0;
		// If tree is not empty then height = 1 + max of left height and right heights.
		return (1 + Math.max(height(node.left), height(node.left)));
	}
	
	// Driver Code
	public static void main(String[] args) {
		
		BT_Problem_04 tree = new BT_Problem_04();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		// Function Call
		System.out.println("The diameter of given bianry tree is : " + tree.diameter());
	}

}
