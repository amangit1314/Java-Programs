package trees.binaryTree;
/*
 * Problem Title :- Check if a tree is balanced or not
 */
public class BT_Problem_14 {

	Node root;
	
	boolean isBalanced(Node node) {
		int lh;
		int rh;
		
		if(node == null)
			return true;
		
		lh = height(node.left);
		rh = height(node.right);
		
		if(Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
			return true;
		}
		return false;
	}
	
	int height(Node node) {
		if(node == null)
			return 0;
		
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	public static void main(String[] args) {

		BT_Problem_14 tree = new BT_Problem_14();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(8);
		
		if(tree.isBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}
