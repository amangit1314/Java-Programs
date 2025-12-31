// Count BST nodes that lie in a given range

class Problem_16 {
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

    // Function to count nodes in BST that lie in the given range
    static int countNodesInRange(Node node, int low, int high) {
        // Base case
        if (node == null) {
            return 0;
        }

        // If current node's data is within range, count it and recur for both subtrees
        if (node.data >= low && node.data <= high) {
            return 1 + countNodesInRange(node.left, low, high) + countNodesInRange(node.right, low, high);
        }
        // If current node's data is less than low, recur for right subtree
        else if (node.data < low) {
            return countNodesInRange(node.right, low, high);
        }
        // If current node's data is greater than high, recur for left subtree
        else {
            return countNodesInRange(node.left, low, high);
        }
    }

    // Driver method to test above methods
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(50);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.right = new Node(100);

        int low = 5, high = 45;
        int count = countNodesInRange(root, low, high);
        System.out.println("Count of nodes in range [" + low + ", " + high + "] is " + count);
    }
}