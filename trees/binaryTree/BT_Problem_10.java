package trees.binaryTree;
/*	Problem Title :- Write a Java program to find Right View of Tree.
 * 
 *  Right View of a tree :- 
 *  The right view of a binary tree, is set of nodes visible when tree is visited from rights side
 *  between two end nodes.
 */
class Max_level{
	int max_level;
}
public class BT_Problem_10 {

	Node root;
	
	Max_level max_level = new Max_level();
	
	void rightViewUtil(Node node, int level, Max_level max_level) {
		
		if(node == null)
			return;
		
		if(max_level.max_level < level) {
			System.out.print(node.data + " " );
			max_level.max_level = level;
		}
		
		rightViewUtil(node.right, level+1,max_level);
		rightViewUtil(node.left, level+1,max_level);
	}
	
	void rightView() {
		rightView(root);
	}
	
	void rightView(Node node) {
		rightViewUtil(node, 1, max_level);
	}
	
	public static void main(String[] args) {
		BT_Problem_10 tree = new BT_Problem_10();
		tree.root = new Node(12);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);
		
		tree.rightView();
		
	}

}
