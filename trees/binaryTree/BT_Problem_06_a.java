package trees.binaryTree;
import java.util.*;
/*	
 * Problem Title :- In-order Traversal of a tree without using Recursion
 */
// Class to print the in-order traversal
public class BT_Problem_06_a {

		// Root of Binary Tree
		Node root;



		/*
		 * Given a binary tree,
		 * print its nodes in in-order
		 */
		void inorder() {
			
			if(root == null)	return;
			
			Stack<Node> s = new Stack<>();
			Node curr = root;
			
			// traverse the tree
			while(curr != null || s.size() > 0) {
				/* Reach the left most Node of the current Node */
				while(curr != null) {
					/* place pointer to a tree node on 
					 * the stack before traversing
					 * the node,s left subtree */
					s.push(curr);
					curr = curr.left;
				}
				
				/*Current must be NULL at this point */
				curr = s.pop();
				
				System.out.print(curr.data + " ");
				
				/* we have visited the node and its left subtree.
				 * Now, its right subtree's turn */
				curr = curr.right;
			}
		}
		
		// Driver method
		public static void main(String[] args) {

			// creating a binary tree and entering the nodes
			BT_Problem_06_a tree = new BT_Problem_06_a();
			
			tree.root = new Node(1);
			tree.root.left = new Node(2);
			tree.root.right = new Node(3);
			tree.root.left.left = new Node(4);
			tree.root.left.right = new Node(5);
			
			tree.inorder();
						
		}

}

