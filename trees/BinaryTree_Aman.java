package trees;

import java.util.*;

public class BinaryTree_Aman {

    private static Node root;

    private static class Node{
        private int data;
        Node left, right;
        Node(int d){
            d = this.data;
            int hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    // Problem 1 -> Level Order Traversal
    public static void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.println(temp.data + " ");

            if(temp.left != null)
                q.add(temp.left);

            if(temp.right != null)
                q.add(temp.right);
        }
    }

    // Problem 2 -> Reverse Level Order Traversal
    public static void reverseLevelOrder(){
        Stack<Node> s = new Stack<>();
        Queue<Node> q = new LinkedList<>();

    }

    // Inorder Traversal of Binary Tree
    public static void inOrder(){
        if(root == null) return;
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while(curr != null || s.size() > 0){
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }
        }

        curr=s.pop();
        System.out.print(curr.data + " ");

        /* we have visited the node and its left subtree.
         * Now, its right subtree's turn */
        curr = curr.right;
    }

    // Recursive Inorder Traversal of Binary Tree
    public static void recursiveInOrder(Node node){
        if(node == null) return;
        recursiveInOrder(node.left);
        System.out.println(node.data + " ");
        recursiveInOrder(node.right);
    }

    // Wrapper for recursive inorder
    void recursiveInOrder(){recursiveInOrder(root);}

    // Preorder Traversal of Binary Tree using recursion
    public static void preOrder(Node node){
        if(node == null) return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    // Wrapper for preorder
    void preOrder(){preOrder(root);}

    // Preorder Traversal of Binary Tree
    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    // Wrapper for Post Order
    void postOrder(){postOrder(root);}

    public static void main(String[] args) {

    }
}