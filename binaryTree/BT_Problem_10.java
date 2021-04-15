package binaryTree;
/*	Problem Title :- Write a Java program to find Right View of Tree.
 * 
 *  Right View of a tree :- 
 *  The right view of a binary tree, is set of nodes visible when tree is visited from rights side
 *  between two end nodes.
 */
public class BT_Problem_10 {

	Node root;
	static int max_level = 0;
	
	void leftViewUtil(Node node, int level) {
		
		if(node == null)
			return;
		
		if(max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}
		
		
	}
	public static void main(String[] args) {
		

	}

}
