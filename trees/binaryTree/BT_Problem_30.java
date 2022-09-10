package trees.binaryTree;
import java.util.*;

// problem Title => Print all "K" Sum paths in a Binary tree
public class BT_Problem_30 {

    //utility function to print contents of a vector from index i to it's end
    static void printVector(Vector<Integer> v, int i) {
        for (int j = i; j < v.size(); j++)
            System.out.print( v.get(j) + " ");
        System.out.println();
    }

    static class Node{
        int data;
        Node left,right;
        Node(int x){
            data = x;
            left = right = null;
        }
    }

    static Vector<Integer> path = new Vector<>();

    static void printKPathUtil(Node root, int k){
        // empty node
        if (root == null)
            return;

        // add current node to the path
        path.add(root.data);

        // check if there's any k sum path in the left sub-tree.
        printKPathUtil(root.left, k);

        // check if there's any k sum path in the right sub-tree.
        printKPathUtil(root.right, k);

        // check if there's any k sum path that
        // terminates at this node
        // Traverse the entire path as
        // there can be negative elements too
        int f = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            f += path.get(j);

            // If path sum is k, print the path
            if (f == k)
                printVector(path, j);
        }

        // Remove the current element from the path
        path.remove(path.size() - 1);
    }

    // A wrapper over printKPathUtil()
    static void printKPath(Node root, int k) {
        path = new Vector<>();
        printKPathUtil(root, k);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 5;
        printKPath(root, k);
    }
}
