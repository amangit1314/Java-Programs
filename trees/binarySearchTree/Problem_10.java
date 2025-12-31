package trees.binarySearchTree;

// Problem Title -> Convert a normal bst into a balanced bst
public class Problem_10 {

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

    // A utility function to store inorder traversal of BST
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

    // A utility function to construct balanced BST from sorted array
    static Node sortedArrayToBST(int arr[], int start, int end) {
        // Base Case
        if (start > end) {
            return null;
        }

        // Get the middle element and make it root
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        // Recursively construct the left subtree and make it left child of root
        node.left = sortedArrayToBST(arr, start, mid - 1);

        // Recursively construct the right subtree and make it right child of root
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    // This function converts an unbalanced BST to a balanced BST
    static Node buildBalancedTree(Node root) {
        // Store nodes of given BST in sorted order
        int n = countNodes(root);
        int inorder[] = new int[n];
        Index index = new Index();
        storeInorder(root, inorder, index);

        // Construct balanced BST from sorted nodes
        return sortedArrayToBST(inorder, 0, n - 1);
    }

    // A utility function to count nodes in a binary tree
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
        // Let us create an unbalanced BST
        Problem_10 tree = new Problem_10();
        tree.root = new Node(10);
        tree.root.right = new Node(20);
        tree.root.right.right = new Node(30);
        tree.root.right.right.right = new Node(40);
        tree.root.right.right.right.right = new Node(50);

        System.out.println("Inorder traversal of the original tree:");
        printInorder(tree.root);

        // Convert to balanced BST
        tree.root = buildBalancedTree(tree.root);

        System.out.println("\nInorder traversal of the balanced tree:");
        printInorder(tree.root);
    }
}