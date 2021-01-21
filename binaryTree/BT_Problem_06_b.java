package binaryTree;

/*	
 * Problem Title :- In-order Traversal of a tree both using Recursion
 */
public class BT_Problem_06_b {

		// Root of Binary Tree
		Node root;
		
		// Constructor
		BT_Problem_06_b(){
			root = null;
		}
		
		/* 
		 * Given a binary tree,
		 *  print its nodes according to the
		 *  "bottom-up" post-order traversal. 
		 */
		void printPostorder(Node node) {
			if(node == null)
				return;
			// first recur on left subtree
			printPostorder(node.left);
			
			// then recur on right subtree
			printPostorder(node.right);
			
			// now deal with the node
			System.out.print(node.data + " ");
		}
		
		/*
		 * Given a binary tree,
		 * print its nodes in in-order
		 */
		void printInorder(Node node) {
			
			if(node == null)	return;
			
			/* first recur on left child */
			printPreorder(node.left);
			
			/* then print data of node */
			System.out.print(node.data + " ");
			
			/* now recur on right child */
			printPreorder(node.right);
		}
		
		/*
		 * Given a binary tree,
		 * print its nodes in preorder
		 */
		void printPreorder(Node node) {
			
			if(node == null)	return;
			
			/* first print data of node */
			System.out.print(node.data + " ");
			
			/* then recur on left subtree */
			printPreorder(node.left);
			
			/* now recur on right subtree */
			printPreorder(node.right);
		}
		
		// Wrappers over above recursive functions
		void printPostorder() { printPostorder(root);}
		void printInorder() { printInorder(root); }
		void printPreorder() { printPreorder(root); }
		
		// Driver method
		public static void main(String[] args) {

			BT_Problem_06_b tree = new BT_Problem_06_b();
			
			tree.root = new Node(1);
			tree.root.left = new Node(2);
			tree.root.right = new Node(3);
			tree.root.left.left = new Node(4);
			tree.root.left.right = new Node(5);
			
			System.out.println("Preorder traversal of binary tree is ");
			tree.printPreorder();
			
			System.out.println("\nInorder traversal of binary tree is ");
			tree.printInorder();
			
			System.out.println("\nPostorder traversal of binary tree is ");
			tree.printPostorder();
			
		}


}
