package trees;

//A Binary Tree Node
class Node{
	int data;
	Node left , right;
	Node(int data) {
		this.data = data;
		left = right = null ;
		
	}
}

public class FindFullNodesInABinaryTree {
	
	//Traverse given tree in In-order fashion & prints all nodes that have both children as non-empty
	public static void findFullNode(Node root) {
		if (root!=null) {
			findFullNode(root.left);
			if(root.left != null && root.right != null) 
				System.out.println(root.data +" ");
			findFullNode(root.right);
		}
	}
	
	//Driver method
	public static void main(String[] args) {
		Node root = new Node(1);  
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		root.right.left.right = new Node(9);
		root.right.left.left = new Node(10);
		root.left.left.left= new Node(11);
		root.left.left.right = new Node(12);
		root.left.right.left = new Node(13);
		root.left.right.right = new Node(14);
		
		findFullNode(root);

	}

}
