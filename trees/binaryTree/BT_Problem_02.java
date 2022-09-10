package trees.binaryTree;
import java.util.*;

// Find Reverse Level Order traversal

public class BT_Problem_02 {

	Node root;
	
	/* Given a binary tree, print its nodes in reverse level order */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void reverseLevelOrder(Node node) {
		
		//Logic for O(n^2) Time Complexity approach 
//		int h = height(node);
//		int i;
//		for(i = h; i >= 1; i--)
//			printGivenLevel(node, i);
		
		Stack<Node> S = new Stack();
		Queue<Node> Q = new LinkedList();
		Q.add(node);
		
		// Do something like normal level order traversal order.
		// Following are the differences with normal level order traversal:
		// 1. Instead of printing a node, we push the node to stack 
		// 2. Right subtree is visited before left subtree.
		while(Q.isEmpty() == false) {
			
			//Dequeue node and make it root
			node = Q.peek();
			Q.remove();
			S.push(node);
			
			//Enqueue right child
			if(node.right != null)
				Q.add(node.right);	//Node RIGHT CHILD IS ENQUEUED BEFORE LEFT
			
			// Enqueue left child 
			if(node.left != null)
				Q.add(node.left);
		}
		
		// Now pop all items from stack one by one and print them
		while(S.empty() == false) {
			node = S.peek();
			System.out.print(node.data + " ");
			S.pop();
		}
		
	}
	
//	void printGivenLevel(Node node, int level) {
//		if(node == null)
//			return;
//		if(level == 1)
//			System.out.print(node.data + " ");
//		else if(level > 1) {
//			printGivenLevel(node.left, level - 1);
//			printGivenLevel(node.right, level - 1);
//		}
//	}
//	
//	int height(Node node) {
//		if(node == null)
//			return 0;
//		else {
//			int lheight = height(node.left);
//			int rheight = height(node.right);
//			
//			if(lheight > rheight)
//				return (lheight + 1);
//			else
//				return (rheight + 1);
//		}
//	}
//	
	public static void main(String[] args) {
		
		BT_Problem_02 tree = new BT_Problem_02();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println("Level Order traversal of binary tree is : ");
		
		tree.reverseLevelOrder(tree.root);
	}
}
