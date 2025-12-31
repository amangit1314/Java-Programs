package trees.binarySearchTree;

// Problem Title -> Find kth smallest element in bst
public class Problem_13 {
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

    // Function to find kth smallest element in BST
    static void kthSmallestUtil(Node node, int k) {
        // Base case
        if (node == null || count >= k) {
            return;
        }

        // Traverse the left subtree
        kthSmallestUtil(node.left, k);

        // Increment count of visited nodes
        count++;

        // If count becomes k now, then this is the k'th smallest
        if (count == k) {
            System.out.println(k + "th smallest element is " + node.data);
            return;
        }

        // Recur for right subtree
        kthSmallestUtil(node.right, k);
    }

    // Wrapper over kthSmallestUtil()
    static void kthSmallest(Node node, int k) {
        count = 0; // Initialize count
        kthSmallestUtil(node, k);
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
        kthSmallest(root, k);
    }
}