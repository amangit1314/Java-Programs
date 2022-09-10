package trees.binaryTree;

import java.util.Stack;

/*
 * Problem Title :- Convert Binary tree into Sum tree.
 */
public class BT_Problem_19 {

	/* A binary tree node has data, pointer to left
   child and a pointer to right child */
	static class Node {
		int data;
		Node left, right;
	}

	/* Helper function that allocates a new node */
	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = node.right = null;
		return (node);
	}

	/* This function is here just to test  */
	static void preOrder(Node node)
	{
		if (node == null)
			return;
		System.out.printf("%d ", node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	// function to return the index of close parenthesis
	static int findIndex(String str, int si, int ei)
	{
		if (si > ei)
			return -1;

		// Inbuilt stack
		Stack<Character> s = new Stack<>();
		for (int i = si; i <= ei; i++) {
			// if open parenthesis, push it
			if (str.charAt(i) == '(')
				s.add(str.charAt(i));

			// if close parenthesis
			else if (str.charAt(i) == ')') {
				if (s.peek() == '(') {
					s.pop();
					// if stack is empty, this is
					// the required index
					if (s.isEmpty())
						return i;
				}
			}
		}

		// if not found return -1
		return -1;
	}

	// function to con tree from String
	static Node treeFromString(String str, int si, int ei)
	{

		// Base case
		if (si > ei)
			return null;

		// new root
		Node root = newNode(str.charAt(si) - '0');
		int index = -1;

		// if next char is '(' find the index of
		// its complement ')'
		if (si + 1 <= ei && str.charAt(si+1) == '(')
			index = findIndex(str, si + 1, ei);

		// if index found
		if (index != -1) {
			// call for left subtree
			root.left = treeFromString(str, si + 2, index - 1);

			// call for right subtree
			root.right = treeFromString(str, index + 2, ei - 1);
		}
		return root;
	}

	// Driver Code
	public static void main(String[] args)
	{
		String str = "4(2(3)(1))(6(5))";
		Node root = treeFromString(str, 0, str.length() - 1);
		preOrder(root);

	}

}
