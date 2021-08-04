package basic_idea_of_DS;

//class containing left & right child of current node & key value
class Node{
	int key;
	Node left,right;
	public Node(int item) {
		key = item;
		left = right = null;
	}
}

// A java program to introduce Binary Tree
public class Tree {
	
	//Root node of binary tree
	Node root;
	
	//Constructors
	Tree(int key){
		root = new Node(key);
	}
	
	Tree(){
		root = null;
	}
	public static void main(String[] args) {
		Tree t = new Tree();
		//create root
		t.root = new Node(1);
		
		/* following is the tree after above statement
		 			1
		 		  /	  \
		 		null  null*/
		
		t.root.left = new Node(2);
		t.root.right = new Node(3);
		/* 2 & 3 become left & right children of 1
		 * 			 1
		 *         /   \
		 *        2     3
		 *      /  \     | \
		 *   null    null  null null
		 */
		t.root.left.left = new Node(4);
		t.root.right.right = new Node(5);
		t.root.right.left = new Node(6);
		t.root.left.right = new Node(7);
	
	}
}
