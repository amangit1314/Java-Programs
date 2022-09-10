// Problem Tiitle => Find inorder successor and inorder predecessor in a BST

public class Problem_4 {

    // BST Node
    static class Node {
        int key;
        Node left, right;

        public Node() {}

        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }
    
    static Node pre = new Node(), suc = new Node();

    // This function finds predecessor and successor of key in BST. 
    // It sets pre and suc as predecessor and successor respectively
    static void findPreSuc(Node root, int key) {

        // Base case
        if (root == null)
            return;

        // If key is present at root
        if (root.key == key) {

            // The maximum value in left subtree is predecessor
            if (root.left != null) {
                Node tmp = root.left;
                while (tmp.right != null)
                    tmp = tmp.right;

                pre = tmp;
            }

            // The minimum value in right subtree is successor
            if (root.right != null) {
                Node tmp = root.right;

                while (tmp.left != null)
                    tmp = tmp.left;

                suc = tmp;
            }
            return;
        }

        // If key is smaller than root's key, go to left subtree
        if (root.key > key) {
            suc = root;
            findPreSuc(root.left, key);
        }

        // Go to right subtree
        else {
            pre = root;
            findPreSuc(root.right, key);
        }
    }

    // A utility function to insert a

    public static void main(String[] args) {
        
    }
}
