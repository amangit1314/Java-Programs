package trees.binarySearchTree;

import java.util.ArrayList;

// Problem Title => Populate Inorder Successor for all nodes
public class Problem_6 {

    static class Node{
        int data;
        Node left, right, next;

        Node(int data){
            this.data = data;
            left = right = next = null;
        }
    }

    Node root;

    ArrayList<Node> list = new ArrayList<>();

    void populateNext(){
        for(int i = 0; i < list.size(); i++){
            if(i != list.size()-1)
                list.get(i).next = list.get(i+1);
            else
                list.get(i).next = null;
        }

        Node ptr = root.left.left;
        while (ptr != null) {
            // -1 is printed if there is no successor
            int print = ptr.next != null ? ptr.next.data : -1;
            System.out.println("Next of " + ptr.data + " is: " + print);
            ptr = ptr.next;
        }
    }

    //insert the inorder into a linkedList.list to keep track of the inorder successor
    void inorder(Node root) {
        if(root!=null) {
            inorder(root.left);
            list.add(root);
            inorder(root.right);
        }
    }

    //Driver function
    public static void main(String[] args) {
        Problem_6 tree = new Problem_6();

        /*         10
               /   \
              8      12
             /
            3                */
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(3);

        //function calls
        tree.inorder(tree.root);
        tree.populateNext();
    }
}