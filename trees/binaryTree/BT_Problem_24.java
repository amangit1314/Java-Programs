package trees.binaryTree;
import java.util.*;
// Problem Title => Check if a Binary Tree contains duplicate subtrees of size 2 or more [ IMP ]
public class BT_Problem_24 {

    static char MARKER = '$';

    static class Node{
        int data;
        Node left,right;
        Node(int item){
            this.data = item;
        }
    }

    public static String dupSubUtil(Node root, HashSet<String> subtrees){
        String s = "";

        // If current node is NULL, return marker
        if (root == null)
            return s + MARKER;

        // If left subtree has a duplicate subtree.
        String lStr = dupSubUtil(root.left,subtrees);
        if (lStr.equals(s))
            return s;

        // Do same for right subtree
        String rStr = dupSubUtil(root.right,subtrees);
        if (rStr.equals(s))
            return s;

        // Serialize current subtree
        s = s + root.data + lStr + rStr;

        // If current subtree already exists in hash table.
        // [Note that size of a serialized tree with single node is 3 as it has two marker nodes].
        if (s.length() > 3 && subtrees.contains(s))
            return "";

        subtrees.add(s);
        return s;
    }

    public static String dupSub(Node root){
        HashSet<String> subtrees=new HashSet<>();
        return dupSubUtil(root,subtrees);
    }

    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
        root.right.right.right = new Node('E');
        root.right.right.left= new Node('D');
        String str = dupSub(root);

        if(str.equals(""))
            System.out.print(" Yes ");
        else
            System.out.print(" No ");
    }
}
