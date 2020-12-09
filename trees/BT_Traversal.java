package trees;

public class BT_Traversal {

	static class Node{
		int key;
		Node left,right;
		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
	
	static Node root;
	BT_Traversal(){
		root = null;
	}
	
	static void printPostorder(Node node) {
		if(node == null) {
			return;
		}
		printPostorder(node.left);
		System.out.print(node.key + " ");
		printPostorder(node.right);
	}
	
	static void printInorder(Node node) {
		if(node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.key + " ");
		printInorder(node.right);
	}
	
	static void printPreorder(Node node) {
		if(node == null) {
			return;
		}
		printPreorder(node.left);
		System.out.print(node.key + " ");
		printPreorder(node.right);
	}
	
	static void printPostorder() {
		printPostorder(root);
	}
	
	static void printInorder() {
		printInorder(root);
	}
	
	static void printPreorder() {
		printPreorder(root);
	}
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		BT_Traversal tree = new BT_Traversal();
		
		root = new Node(1);
		root.left = new Node(11); 
        root.right = new Node(9); 
        root.left.left = new Node(7); 
        root.right.left = new Node(15); 
        root.right.right = new Node(8);
        
        System.out.println( "Inorder traversal of given tree is:"); 
		BT_Traversal.printInorder();
		System.out.println();
		
		System.out.println( "Postorder traversal of given tree is:"); 
		BT_Traversal.printPostorder();
		System.out.println();
		
		System.out.println( "Preorder traversal of given tree is:"); 
		BT_Traversal.printPreorder();
	}

}
