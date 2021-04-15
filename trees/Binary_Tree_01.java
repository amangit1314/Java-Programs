package trees;

/*
 * Level Order Traversal
 */

/*
 * Algorithm:
 * There are basically two functions in this method.
 * One is to print all node at a given level(printGIvenLevel),
 * and other is to print level order traversal of the tree(printLevelorder).
 * printLevelorder makes use of printGivenLevel to print nodes at all levels one by one starting from root.
 */

//Recursive Java program for level order traversal of Binary Tree

class Binary_Tree_01 {

	/* Class containing left and right child of current node and key value */
	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	// Root of the Binary Tree
	Node root;

	public Binary_Tree_01() {
		root = null;
	}

	/* function to print level order traversal of tree */
	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
	 */
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		Binary_Tree_01 tree = new Binary_Tree_01();
		tree.new Node(1);
		tree.new Node(2);
		tree.new Node(3);
		tree.new Node(4);
		tree.new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}
}
