package trees;

//Node of tree
class Node{
	int data;
	Node left,right;
	
	//making public constructor of Node class 
	public Node(int item) {
		data = item;
		left = right = null;
	}
}

//main class to find linear order traversal
public class BinaryTree_LOT {
	
	//root node
	Node root;
	
	//making an constructor
	public BinaryTree_LOT() {
		root = null;
	}
	
	//function to print level order 
	void printLevelOrder() {
		
		//variable to store height which will be received from height function
		int h = height(root), i;
		
		//loop for calculating given level
		for(i = 1 ; i<= h ; i++)
			printGivenLevel(root, i);
	}
	
	//function to find the height of tree
	int height(Node root) {
		
		//if their is no value at root node or node is empty then simply return 0;
		if(root == null)
			return 0;
		
		else {
			//declare l-height for height of left & r-height variables for height of right, by using recursive call
			int lheight = height(root.left);
			int rheight = height(root.right);
			
			//if(l-height is greater then r-height then return(l-height + 1); 
			if(lheight > rheight)
				return(lheight + 1);
			
			//else return r-height + 1;
			else return(rheight + 1);
		}
	}
	
	//function to print the given level of tree
	void printGivenLevel(Node root, int level) {
		
		//if their is no value at root node or node is empty then simply return;
		if(root == null)
			return;
		
		//if level is equal to 1 then print the data of root node 
		if(level == 1)
			System.out.print(root.data + " ");
		
		//else if level is greater then 1, then call the function "RECUSIVELY" for left node & -1th level
		else if(level > 1) {
			//recursive call for left node at level-1 level
			printGivenLevel(root.left,  level-1);
			
			//recursive call for right node at level-1 level
			printGivenLevel(root.right, level-1);
		}
	}

	//main or driver method
	public static void main(String[] args) {
		
		//Making an object of BinaryTree_LOT class
		BinaryTree_LOT tree = new BinaryTree_LOT();
		
		//setting values of the different nodes of tree with use of tree object of tree classs
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println("Level order traversal of binary tree is ");
		
		//calling printLevelOrder() function
		tree.printLevelOrder();

	}

}
