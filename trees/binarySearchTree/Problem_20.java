// Check whether BST Contains dead end

class Problem_20 {
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

    // Function to insert a new node with given key in BST
    static Node insert(Node node, int key) {
        // If the tree is empty, return a new node
        if (node == null) {
            return new Node(key);
        }

        // Otherwise, recur down the tree
        if (key < node.data) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }
        return node;
    }

    // Function to check if BST contains dead end
    static boolean isDeadEnd(Node root) {
        return isDeadEndUtil(root, 1, Integer.MAX_VALUE);
    }

    // Utility function to check for dead ends
    static boolean isDeadEndUtil(Node node, int min, int max) {
        // Base case
        if (node == null) {
            return false;
        }

        // If this is a leaf node, check if min and max are equal
        if (node.left == null && node.right == null) {
            return (min == max);
        }

        // Recur for left and right subtrees with updated min and max
        return isDeadEndUtil(node.left, min, node.data - 1) ||
               isDeadEndUtil(node.right, node.data + 1, max);
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 8);
        insert(root, 5);
        insert(root, 9);
        insert(root, 7);
        insert(root, 2);
        insert(root, 1);
        insert(root, 3);

        if (isDeadEnd(root)) {
            System.out.println("BST contains dead end");
        } else {
            System.out.println("BST does not contain dead end");
        }
    }
}