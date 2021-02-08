package trees;

	/*
	* Code : Count leaf nodes
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
	*
	* 4
	*/

public class Count_leaf_nodes {
	static int calcNodes(int N, int I){
		int result;
		result = I * (N - 1) + 1;
		return result;
	}
	public static void main(String[] args) {
		int N = 5, I = 2;
		System.out.println("Leaf nodes = " + calcNodes(N, I));
	}
}
