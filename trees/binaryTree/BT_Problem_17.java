package trees.binaryTree;
import java.util.*;
/*	
 * Problem Title :- Construct Binary Tree from String with Bracket Representation. 
 */
public class BT_Problem_17 {
	// Binary Tree node
	static class Node{
		int data;
		Node left, right;
	};
	
	// Helper function that allocates a new node
	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = node.right = null;
		return(node);
	}
	
	// function just for testing
	static void preOrder(Node node) {
		if(node == null)
			return;
		System.out.printf("%d ", node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	// function to return the index of close parenthesis
	static int findIndex(String str, int si, int ei) {
		// base case
		if(si > ei)	
			return -1;
		//Inbuilt Stack
		Stack<Character> s = new Stack<>();
		// loop for iterations of the index
		for(int i = si; i <= ei; i++) {
			// if open parenthesis, push it to the stack
			if(str.charAt(i) == '(')	
				s.add(str.charAt(i));
			// if close parenthesis, pop it and else stack is empty that will be the required index 
			else if(str.charAt(i) == ')') {
				if(s.peek() == '(') {
					// pop from stack
					s.pop();
					//if stack is empty, this is the required index
					if(s.isEmpty())	return i;
				}
			}
		}
		return -1;
	}
	
	// function to construct tree from string
	static Node treeFromString(String str, int si, int ei) {
		
		// Base Case
		if(si > ei)	return null;
		
		// new root
		Node root = newNode(str.charAt(si) - '0');
		int index = -1;
		
		// if next char is '(' find the index of its complement
		if(si + 1 <= ei && str.charAt(si+1) == '(') 
			index = findIndex(str, si + 1, ei);
		
		// if index found
		if(index != -1) {
			// call for left subtree
			root.left = treeFromString(str, si+2, index - 1);
			// call for left subtree
			root.right = treeFromString(str, index + 2, ei - 1);
		}
		return root;
	}
	
	//Driver Code
	public static void main(String[] args) {
		String str = "4(2(3)(1))(6(5))";
		Node root = treeFromString(str, 0, str.length() - 1);
		preOrder(root);
	}

}
