package trees.binaryTree;

/*	Problem Title :- Write a Java program to find Left View of a tree
 * 
 *  Left View of a tree :- 
 *  The left view of a binary tree, is set of nodes visible when tree is visited from left side
 *  between two end nodes.
 */
public class BT_Problem_09 {

	Node root;
	static int max_level = 0;
	
	// recursive function to print the left view
	void leftViewUtil(Node node, int level) {
		// Base Case
		if(node == null)
			return;
		
		// If this is the first node of its level
		if(max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}
		
		// Recur for left and right subtrees
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}
	
	// A wrapper over leftViewUtil()
	void leftView() {
		leftViewUtil(root, 1);
	}
	
	// Driver Code
	public static void main(String[] args) {

		/* creating a binary tree and entering the nodes */
		BT_Problem_09  tree = new BT_Problem_09();
		
		tree.root = new Node(12);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);
		
		tree.leftView();
	}

}
