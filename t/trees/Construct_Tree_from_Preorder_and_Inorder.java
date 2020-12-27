package trees;


/*
 * Code: Construct Tree from Preorder and Inorder
 * 
 *
 *Given Pre-order and In-order traversal of a binary tree, 
 *create the binary tree associated with the traversals.
 *You just need to construct the tree and return the root.
 *
 *Note: Assume binary tree contains only unique elements.
 *
 * Input format :
 *
 *	Line 1 : n (Total number of nodes in binary tree)
 *	Line 2 : Pre order traversal
 *	Line 3 : Inorder Traversal
 *
 * Output Format :
 *
 * Elements are printed level wise, each level in new line (separated by space).
 *
 * Sample Input :
 *	12
 *	1 2 3 4 15 5 6 7 8 10 9 12
 *	4 15 3 2 5 1 6 10 8 7 9 12
 *
 * Sample Output :
 *	1 
 *	2 6 
 *	3 5 7 
 *	4 8 9 
 *	15 10 12
 */
public class Construct_Tree_from_Preorder_and_Inorder {
	
	public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre , int[] in){
		return helper (0, 0, in.length - 1, pre, in);
	}
	
	private static BinaryTreeNode<Integer> helper(int preStart , int inStart , int inEnd , int[] preorder , int[] inorder){
		
		//Base Case
		if(preStart > preorder.length || inStart > inEnd) 
			return null;
		
		
		//get the root node with current pre-order element
		 BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder[preStart]);
		 
		 //get inIndex; finding preorder's element's index in in-order
	     int inIndex = 0;
	        
	     for(int i = inStart ; i<= inEnd ; i++) {
	    	 if(inorder[i] == root.data)
	    		 inIndex = i;
	     }
	     
	     //(next, left of inIndex is the end for left subtree)
	        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	        
	     //(prestart + length of left subtree + 1)
	        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	        
	        return root;
	}

}
