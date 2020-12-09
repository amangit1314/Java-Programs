package trees;

//java program for different tree traversals
/*
 * Class containing left and right child of current node and key value
 */
//class Node{
//	int key;
//	Node left, right;
//	
//	public Node(int item) {
//		key = item;
//		left = right = null;
//	}
//}

public class BinaryTree_Traversal {
	
	//root of binary Tree
	Node root;
	
	BinaryTree_Traversal(){
		root = null;
	}
	
	void printPostorder(Node node) {
		
		if(node == null)
			return;
		
		printPostorder(node.left);
		
		printPostorder(node.right);
		
		System.out.print(node.key + " ");
	}
	
	void printInorder(Node node) {
		
		if(node == null)
			return;
		
		printInorder(node.left);
		
		System.out.println(node.key + " ");
		
		printInorder(node.right);
	}
	
	void printPreorder(Node node) {
		
		if(node == null)
			return;
		
		System.out.println(node.key + " ");
		
		printPreorder(node.left);
		
		printPreorder(node.right);
	}
	
	void printPostorder() {
		printPostorder(root);
	}
	
	void printInorder() {
		printInorder(root);
	}
	
	void printPreorder() {
		printPreorder(root);
	}

	public static void main(String[] args) {
		
		BinaryTree_Traversal tree = new BinaryTree_Traversal();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();
		
		System.out.println("\n Inorder traversal of bianry tree is ");
		tree.printInorder();
		
		System.out.println("\n Postorder traversal of bianry tree is ");
		tree.printPostorder();
		
	}

}
