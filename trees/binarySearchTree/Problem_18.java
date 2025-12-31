// Given n appointments, find the conflicting appointments

class Problem_18 {
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

    // Function to check for conflicts in appointments
    static boolean hasConflict(Node node, int start, int end) {
        // Base case
        if (node == null) {
            return false;
        }

        // If current node's data lies within the range, there is a conflict
        if (node.data >= start && node.data <= end) {
            return true;
        }

        // If current node's data is less than start, check right subtree
        if (node.data < start) {
            return hasConflict(node.right, start, end);
        }

        // If current node's data is greater than end, check left subtree
        return hasConflict(node.left, start, end);
    }

    // Driver method to test above methods
    public static void main(String args[]) {
        Node root = null;
        int[] appointments = {10, 20, 30, 40, 50};

        // Insert appointments into BST
        for (int appt : appointments) {
            root = insert(root, appt);
        }

        int newStart = 25;
        int newEnd = 35;

        if (hasConflict(root, newStart, newEnd)) {
            System.out.println("Conflict detected for appointment [" + newStart + ", " + newEnd + "]");
        } else {
            System.out.println("No conflict for appointment [" + newStart + ", " + newEnd + "]");
        }
    }
}