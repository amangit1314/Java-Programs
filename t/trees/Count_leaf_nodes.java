package trees;
import java.util.*;

	/*Code : Count leaf nodes
	* Send Feedback
	* Given a generic tree, count and return the number of leaf nodes present in the given tree.
	* Input format :
	* Elements in level order form separated by space (as per done in class). Order is - 
	* Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
	* Output Format :
	* Count of leaf nodes
	* Sample Input 1 :
	* 10 3 20 30 40 2 40 50 0 0 0 0 
	* Sample Output 1 :
	*  4 */

public class Count_leaf_nodes {

	  class BinaryTreeNode<T> {
			T data;
			ArrayList<BinaryTreeNode<T>> children;

			BinaryTreeNode(T data){
				this.data = data;
				children = new ArrayList<BinaryTreeNode<T>>();
			}
		
			public int countLeafNodes(BinaryTreeNode<Integer> root){
			
				int leaf = 0;
	        
				if (root == null )
					return 0;
	      
				if (root.children.size() == 0)
					return 1;
	    
				for (BinaryTreeNode<Integer> child : root.children) 
					leaf += countLeafNodes(child);
	  	
				return leaf ;
			}	
	  }
}
