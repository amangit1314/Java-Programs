package trees.binaryTree;

/*	Problem Title :- Find the Height of a tree or Maximum Depth of a tree.
 * 
 *  Height of tree :- 
 *  The height of a tree is the number of edges on the longest downward path
 *  between the root and a leaf.
 */
public class BT_Problem_03 {

	Node root;
	
	/* 
	 * Compute the "maxDepth" of a tree -- 
	 * the number of nodes along the longest path from the root node
	 * down to the farthest leaf node
	 */
	int maxDepth(Node node) {
		
		if(node == null)	return 0;
		
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);
			
			/* use the larger one*/
			if(lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
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
