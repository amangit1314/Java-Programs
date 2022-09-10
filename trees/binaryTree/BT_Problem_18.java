package trees.binaryTree;
/*	
 * Problem Title :- Convert Binary tree into Doubly Linked List 
 */
public class BT_Problem_18 {

	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}

	Node root, head;
	static Node prev = null;

	void BinaryTree2DLL(Node root){
		// Base case
		if (root == null)
			return;

		// Recursively convert left subtree
		BinaryTree2DLL(root.left);

		// Now convert this node
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		BinaryTree2DLL(root.left);
	}

	void printList(Node node) {
		while (node != null)
		{
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

	public static void main(String[] args) {
		BT_Problem_18 tree = new BT_Problem_18();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);

		// convert to DLL
		tree.BinaryTree2DLL(tree.root);

		// Print the converted List
		tree.printList(tree.head);
	}

}
