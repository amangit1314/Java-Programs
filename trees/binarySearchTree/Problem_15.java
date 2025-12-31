package trees.binarySearchTree;

// Problem Title -> Find median of Bst in O(n) time and O(1) space
public class Problem_14 {
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

    // Function to count nodes in BST
    static int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return countNodes(node.left) + countNodes(node.right) + 1;
    }

    // Function to find median of BST
    static void findMedianUtil(Node node, int n, int[] currCount, Integer[] prev, Double[] median) {
        if (node == null || median[0] != null) {
            return;
        }

        // Traverse the left subtree
        findMedianUtil(node.left, n, currCount, prev, median);

        // Increment count of visited nodes
        currCount[0]++;

        // If n is odd
        if (n % 2 != 0 && currCount[0] == (n + 1) / 2) {
            median[0] = (double) node.data;
            return;
        }
        // If n is even
        else if (n % 2 == 0 && currCount[0] == (n / 2) + 1) {
            median[0] = (prev[0] + node.data) / 2.0;
            return;
        }

        // Store previous node data
        prev[0] = node.data;

        // Recur for right subtree
        findMedianUtil(node.right, n, currCount, prev, median);
    }

    // Wrapper over findMedianUtil()
    static Double findMedian(Node root) {
        int n = countNodes(root);
        int[] currCount = {0};
        Integer[] prev = {null};
        Double[] median = {null};

        findMedianUtil(root, n, currCount, prev, median);
        return median[0];
    }

    // Driver method to test above methods
    public static void main(String args[]) {
        Problem_14 tree = new Problem_14();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
}