package trees.binaryTree;
import java.util.*;

// Problem Title => Find all Duplicate subtrees in a Binary tree [ IMP ]

public class BT_Problem_34 {

    static HashMap<String, Integer> m;

    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static String inorder(Node node){
        if(node == null) return "";
        String str = "(";
        str += inorder(node.left);
        str += Integer.toString(node.data);
        str += inorder(node.right);
        str += ")";

        // Subtree already present
        // (Note that we use HashMap instead of HashSet because we want to print multiple duplicates only once,
        // consider example of 4 in above subtree,
        // it should be printed only once.
        if (m.get(str) != null && m.get(str)==1 )
            System.out.print( node.data + " ");

        if (m.containsKey(str))
            m.put(str, m.get(str) + 1);
        else
            m.put(str, 1);


        return str;
    }

    static void printAllDups(Node root) {
        m = new HashMap<>();
        inorder(root);
    }

    // Driver code
    public static void main(String[] args) {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        printAllDups(root);
    }
}
