package trees.binaryTree;
import java.util.*;

public class Morris_Traversal {
    // Find Level order traversal of binary tree
    static class Node{
        int data;
        int hd;
        Node left, right;

        public Node(int item) {
            data = item;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    static Node root;

    public static void printMorrisTraversal(Node root){
        Queue<Node> tq = new LinkedList<>();
        Node curr,prev;

        if(root == null) return;

        curr = root;

        while(curr != null){
            if(curr.left == null){
                System.out.println(curr.data);
                curr = curr.right;
            }
            else {
                prev = curr.left;
                while(prev.right != null && prev.right != curr)
                    prev = prev.right;

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    System.out.println(curr.data + " ");
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Morris_Traversal tree = new Morris_Traversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.printMorrisTraversal(tree.root);
    }
}