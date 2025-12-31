package trees.binarySearchTree;

// Problem Title -> Find kth largest element in bst
public class Problem_12 {
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
    static int count = 0;

    // Function to find kth largest element in BST
    static void kthLargestUtil(Node node, int k) {
        // Base case
        if (node == null || count >= k) {
            return;
        }

        // Follow reverse inorder traversal so that the largest element is visited first
        kthLargestUtil(node.right, k);

        // Increment count of visited nodes
        count++;

        // If count becomes k now, then this is the k'th largest
        if (count == k) {
            System.out.println(k + "th largest element is " + node.data);
            return;
        }

        // Recur for left subtree
        kthLargestUtil(node.left, k);
    }

    // Wrapper over kthLargestUtil()
    static void kthLargest(Node node, int k) {
        count = 0; // Initialize count
        kthLargestUtil(node, k);
    }

    // Driver method to test above methods
    public static void main(String args[]) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        int k = 3;
        kthLargest(root, k);
    }
}