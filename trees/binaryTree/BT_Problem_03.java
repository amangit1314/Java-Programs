package trees.binaryTree;

class Node {
	int data;
	Node root, left, right;

	public Node(int value) {
		data = value;
		root = left = right = null;
	}
}

/*
 * Problem Title :- Find the Height of a tree or Maximum Depth of a tree.
 * 
 * Height of tree :-
 * The height of a tree is the number of edges on the longest downward path
 * between the root and a leaf.
 */
public class BT_Problem_03 {

	Node root;

	/*
	 * Compute the "maxDepth" of a tree --
	 * the number of nodes along the longest path from the root node
	 * down to the farthest leaf node
	 */
	int maxDepth(Node node) {

		// base case
		if (node == null)
			return 0;

		else {
			/* compute the depth of each subtree */
			int leftDepth = maxDepth(node.left);
			int rightDepth = maxDepth(node.right);

			/* if left is larger use left depth */
			if (leftDepth > rightDepth)
				return (leftDepth + 1);

			/* otherwise use right depth */
			else
				return (rightDepth + 1);

			/**
			 * Note: The +1 ensures that each node's contribution to the overall
			 * height is included as the recursion unwinds,
			 * ultimately providing the correct height of the tree.
			 */
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {

		BT_Problem_03 tree = new BT_Problem_03();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Height of tree is : " + tree.maxDepth(tree.root));

	}

}
