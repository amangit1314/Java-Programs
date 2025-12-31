// Flatten BST to sorted  list

class Problem_22 {
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

    // Function to perform in-order traversal and store nodes in a list
    static void inorderTraversal(Node node, java.util.List<Node> nodeList) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, nodeList);
        nodeList.add(node);
        inorderTraversal(node.right, nodeList);
    }

    // Function to flatten the BST to a sorted linked list
    static Node flattenBSTToSortedList(Node root) {
        java.util.List<Node> nodeList = new java.util.ArrayList<>();
        inorderTraversal(root, nodeList);

        // Re-link nodes to form a sorted linked list
        for (int i = 0; i < nodeList.size() - 1; i++) {
            Node current = nodeList.get(i);
            Node next = nodeList.get(i + 1);
            current.left = null; // Set left child to null
            current.right = next; // Set right child to next node
        }

        // Handle the last node
        if (!nodeList.isEmpty()) {
            Node lastNode = nodeList.get(nodeList.size() - 1);
            lastNode.left = null;
            lastNode.right = null;
        }

        // Return the head of the sorted linked list
        return nodeList.isEmpty() ? null : nodeList.get(0);
    }

    // Utility function to print the sorted linked list
    static void printSortedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem_22 tree = new Problem_22();
        tree.root = insert(tree.root, 5);
        insert(tree.root, 3);
        insert(tree.root, 7);
        insert(tree.root, 2);
        insert(tree.root, 4);
        insert(tree.root, 6);
        insert(tree.root, 8);

        Node sortedListHead = flattenBSTToSortedList(tree.root);
        printSortedList(sortedListHead);
    }
}