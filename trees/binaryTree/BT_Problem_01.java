package trees.binaryTree;
import java.util.*;

// Find Level order traversal of binary tree
class Node{
	int data;
	int hd;
	Node left, right;
	
	public Node(int item) {
		data = item;
		hd = Integer.MAX_VALUE;
		left = right = null;
	}
}
public class BT_Problem_01 {
	
	Node root;
	
	void printLevelOrder() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			
			if(tempNode.left != null) 
				queue.add(tempNode.left);
			
			if(tempNode.right != null)
				queue.add(tempNode.right);
		}
	}
	public static void main(String[] args) {
		
		BT_Problem_01 tree_level = new BT_Problem_01();
		
		tree_level.root = new Node(1);
		tree_level.root.left = new Node(2);
		tree_level.root.right = new Node(3);
		tree_level.root.left.left = new Node(4);
		tree_level.root.left.right = new Node(5);
		
		System.out.println("Level order traversal of binary tree is - ");
		tree_level.printLevelOrder();
	}

}
