package trees;

import java.util.*;

//A Binary Tree Node
class Node {

	int data;
	Node left, right;

	// Constructor of Node Class
	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class Count_Nodes {

	Node root;

	// Traverse given tree in In-order fashion & prints all nodes that have both
	// children as non-empty
	int getFullCount() {
		if (root == null)
			return 0;

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		int count = 0;

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp.left != null && temp.right != null)
				count++;

			if (temp.left != null)
				queue.add(temp.left);

			if (temp.right != null)
				queue.add(temp.right);

		}

		return count;
	}

	public static void main(String[] args) {
		Count_Nodes tree_level = new Count_Nodes();
		tree_level.root = new Node(2);
		tree_level.root.left = new Node(7);
		tree_level.root.right = new Node(5);
		tree_level.root.left.right = new Node(6);
		tree_level.root.left.right.left = new Node(1);
		tree_level.root.left.right.right = new Node(11);
		tree_level.root.right.right = new Node(9);
		tree_level.root.right.right.left = new Node(4);

		System.out.println(tree_level.getFullCount());
	}

}
