package trees.binaryTree;
import java.util.*;

/*
 *  Problem Title :- Zig-Zag traversal of a binary tree 
 */

class BinaryTree{
	
	Node root;
	
	void printZigZagTraversal() {
		if(root == null)
			return;
		
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();
		
		currentLevel.push(root);
		boolean leftToRight = true;;
		
		while(!currentLevel.isEmpty()) {
			Node node = currentLevel.pop();
			
			System.out.print(node.data + " ");
			
			if(leftToRight) {
				if(node.left != null) {
					nextLevel.push(node.left);
				}
			
				if(node.left != null) {
					nextLevel.push(node.left);
				}
			}
			
			else {
				if(node.right != null) {
					nextLevel.push(node.right);
				}
				if(node.left != null) {
					nextLevel.push(node.left);
				}
			}
			
			if(currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}
}

public class BT_Problem_13 {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		tree.root = new Node(1);
		tree.root.left = new Node(8);
		tree.root.right = new Node(21);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(6);
		tree.root.left.right.left = new Node(5);
		tree.root.left.right.right = new Node(4);
		
		System.out.println("ZigZag Order traversal tree is ");
		tree.printZigZagTraversal();
		
	}

}
