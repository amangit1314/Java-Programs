/*
 * Check if generic tree contain element x
 * 
 * Send Feedback
 * Given a generic tree and an integer x, check if x is present in the given tree or not.
 *  Return	: true 	:- 	 if x is present,
 *  Return : false	:-	 otherwise.
 *  
 * Input format :
 * Line 1 : Integer x
 * Line 2 : Elements in level order form separated by space (as per done in class). 
 * 
 * Order is -
 * Root_data , n (No_Of_Child_Of_Root) , n children , and so on for every element.
 * 
 * Output format : true or false
 * Sample Input 1 :
 * 40
 * 10 3 20 30 40 2 40 50 0 0 0 0 
 * 
 * Sample Output 1 :
 *  true
 *  
 * Sample Input 2 :
 * 4
 * 10 3 20 30 40 2 40 50 0 0 0 0 
 * 
 * Sample Output 2:
 * false
 */

package trees;
import java.util.*;

public class Problem_01 {
	//	TreeNode class 
	class TreeNode<T> {
			T data;
			ArrayList<TreeNode<T>> children;

			TreeNode(T data){
				this.data = data;
				children = new ArrayList<TreeNode<T>>();
			}
		}
	
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

		// Write your code here
          if(root==null)
            return false;
          
		// Write your code here		
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        
        //added 1st level here 
        queue.add(root);
        queue.add(null);
		@SuppressWarnings("unused")
		int ans=0;
        
        // if(x<root.data)
        //     ans++;
        while(!queue.isEmpty())
        {
            TreeNode<Integer> frontNode = queue.remove();
            if(frontNode == null)
            {
                if(queue.isEmpty())
                    break;
                
                queue.add(null);
            }
            else{
               		 if(frontNode.data==x)
           			 		return true;
                System.out.print(frontNode.data+" ");
                
                for(int i=0;i<frontNode.children.size();i++)
                    queue.add(frontNode.children.get(i));
            }
        }
        return false;    
	}
}
