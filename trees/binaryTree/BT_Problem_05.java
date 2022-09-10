package trees.binaryTree;

/*	Problem Title :- Find Mirror of a tree.
 * 
 *  Mirror of a tree :- 
 *  The Diameter of a tree is the number of nodes on the longest path
 *  between two end nodes.
 */
public class BT_Problem_05 {

	/*
	 * A binary tree node has data, 
	 * pointer to left child 
	 * & a pointer to right child
	 */
	static class node{
		int val;
		node left;
		node right;
	}
	
	/*
	 * Helper function that allocates a new node with the given data
	 * & null left and right pointers
	 */
	static node createNode(int val) {
		node newNode = new node();
		newNode.val = val;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}
	
	/*
	 * Helper function to print
	 * In-order Traversal
	 */
	static void inorder(node root) {
		if(root == null)
			return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
	
	/*
	 * mirror-i-f-y function takes two trees,
	 * original tree and a mirror tree
	 * It recurses on both the trees.
	 * but when original tree recurses on left,
	 * mirror tree recurses on right and vice-versa
	 */
	static node mirrorify(node root) {
		if(root == null)
			return null;
		
		// Create new mirror node from original tree node
		node mirror = createNode(root.val);
		mirror.right = mirrorify(root.left);
		mirror.left = mirrorify(root.right);
		return mirror;
	}
	
	// Driver Code
	public static void main(String[] args) {

		node tree = createNode(5);
		tree.left = createNode(5);
		tree.right = createNode(5);
		tree.left.right = createNode(5);
		tree.left.left = createNode(5);
		
		// print in-order traversal of the original input tree
		System.out.print("\n Inorderr of original tree: ");
		inorder(tree);
		node mirror = null;
		mirror = mirrorify(tree);
		
		// print in-order traversal of the mirror tree
		System.out.print("\n Inorderr of mirror tree: ");
		inorder(mirror);
	}

}
