package trees;
import java.util.*;

public class BinaryTreeUse {
	
	public static BinaryTreeNode<Integer> takeInput(Scanner s){
		int rootdata;
		System.out.println("Enter root data: ");
		rootdata = s.nextInt();
		
		if(rootdata == -1)	return null;
		
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
		
	}
	
	public static void printTree(BinaryTreeNode<Integer> root) {
		if(root == null)	return;
		String s = root.data+" ";
		
		if(root.left!=null)
			s+="L. "+root.left.data+" ,";
		
		if(root.right!=null)
			s+="R. "+root.right.data;
		
		System.out.println(s);
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {
		
//		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(1);
//		BinaryTreeNode<Integer> node1=new BinaryTreeNode<Integer>(2);
//		root.left=node1;
//		BinaryTreeNode<Integer> node2=new BinaryTreeNode<Integer>(3);
//		root.left=node2;
		
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		printTree(root);
		s.close();

	}

}
