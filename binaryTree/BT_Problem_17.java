package binaryTree;
/*
 * Problem Title :- Construct Binary Tree from String with Bracket Representation
 */
public class BT_Problem_17 {

	static class Node{
		int data;
		Node left,right;
	};
	
	static String str;
	
	static Node newNode(int data) {
		Node node = new Node();
		node.data= data;
		node.left = node.right = null;
		return(node);
	}
	
	static void treeToString(Node root) {
		if(root == null)
			return;
		
		str += (Character.valueOf((char)(root.data + '0')));
		
		if(root.left == null && root.right == null) {
			return;
		}
		
		str += ('(');
		treeToString(root.left);
		str += ('(');
		
		if(root.right != null) {
			str += ('(');
			treeToString(root.right);
			str += ('(');
		}
	}
	
	public static void main(String[] args) {
		Node root = newNode(1);
		root.left = newNode(2);
		root.right = newNode(3);
		root.left.left = newNode(4);
		root.left.right = newNode(5);
		root.right.right = newNode(6);
		str = " ";
		treeToString(root);
		System.out.println(str);

	}

}
