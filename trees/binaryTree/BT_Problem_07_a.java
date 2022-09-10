package trees.binaryTree;
import java.util.*;

/*	
 * Problem Title :- Preorder Traversal of a tree without using Recursion or Iteratively
 */
public class BT_Problem_07_a {

	// Root of Binary Tree
			Node root;
			
	// Given a binary tree, print its nodes in pre-order
	void preorder() {
				
		if(root == null)	return;
				
		Stack<Node> s = new Stack<>();
		s.push(root);
				
		// traverse the tree
		while(s.empty() == false) {
			
			Node mynode = s.peek();
			System.out.print(mynode.data + " ");
			
			s.pop();
			
			//Push right child of popped node to stack
			if(mynode.right != null) 
				s.push(mynode.right);
			
			//Push left child of popped node to stack
			if(mynode.left != null) 
				s.push(mynode.left);
			
		}
	}
			
	// Driver method
	public static void main(String[] args) {

		// creating a binary tree and entering the nodes
		BT_Problem_07_a tree = new BT_Problem_07_a();
				
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
				
		tree.preorder();
							
	}

}
