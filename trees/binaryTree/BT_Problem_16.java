package trees.binaryTree;
/*
 * Problem Title :- Boundary traversal of a Binary tree
 */
public class BT_Problem_16 {

	Node root;
	// printing leaf nodes
	void printLeaves(Node node) {
		if(node == null)
			return;
		
		printLeaves(node.left);
		// print if it is a leaf node
		if(node.left == null && node.right == null)
			System.out.print(node.data + " ");
		printLeaves(node.right);
	}
	
	void printBoundaryLeft(Node node) {
		if(node == null)
			return;
		if(node.left != null) {
			System.out.print(node.data + " ");
			printBoundaryLeft(node.left);
		}
		
		else if(node.right != null) {
			System.out.print(node.data + " ");
			printBoundaryLeft(node.right);
		}
	}
	
	void printBoundaryRight(Node node) {
		if(node == null)
			return;
		if(node.left != null) {
			System.out.print(node.data + " ");
			printBoundaryRight(node.left);
		}
		
		else if(node.right != null) {
			System.out.print(node.data + " ");
			printBoundaryRight(node.right);
		}
	}
	
	void printBoundary(Node node) {
		if(node == null)
			return;
		
		System.out.print(node.data + " ");
		
		printBoundaryLeft(node.left);
		
		printLeaves(node.left);
		printLeaves(node.right);
		
		printBoundaryRight(node.right);
	}
	
	public static void main(String[] args) {
		BT_Problem_16 tree = new BT_Problem_16();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(8);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(3);
		tree.root.right.right = new Node(22);
		
		tree.printBoundary(tree.root);

	}

}
