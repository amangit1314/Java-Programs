package trees.binarySearchTree;

// Problem Title -> Construct bt to bst
public class Problem_9 {

    // A binary tree node
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    // Function to store the inorder traversal of tree
    static void storeInorder(Node node, int inorder[], Index index) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        storeInorder(node.left, inorder, index);

        // Store the data of node
        inorder[index.index] = node.data;
        index.index++;

        // Traverse the right subtree
        storeInorder(node.right, inorder, index);
    }

    // Function to copy array elements back to tree
    static void arrayToBST(int inorder[], Node node, Index index) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        arrayToBST(inorder, node.left, index);

        // Copy the data to node
        node.data = inorder[index.index];
        index.index++;

        // Traverse the right subtree
        arrayToBST(inorder, node.right, index);
    }

    // This function converts a given binary tree to BST
    static void binaryTreeToBST(Node root) {
        // Base case
        if (root == null) {
            return;
        }

        // Count the number of nodes in Binary Tree
        int n = countNodes(root);

        // Create an array to store inorder traversal
        int inorder[] = new int[n];
        Index index = new Index();
        index.index = 0;

        // Store inorder traversal of tree in array
        storeInorder(root, inorder, index);

        // Sort the array
        java.util.Arrays.sort(inorder);

        // Copy array elements back to tree
        index.index = 0;
        arrayToBST(inorder, root, index);
    }

    // Function to count number of nodes in binary tree
    static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    // Utility class to hold index value
    static class Index {
        int index;
    }

    // A utility function to do inorder traversal of BST
    static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Problem_9 tree = new Problem_9();
        tree.root = new Node(10);
        tree.root.left = new Node(30);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(15);

        System.out.println("Inorder Traversal of given tree");
        printInorder(tree.root);

        // Convert binary tree to BST
        binaryTreeToBST(tree.root);

        System.out.println("\nInorder Traversal of converted BST");
        printInorder(tree.root);
    }
}