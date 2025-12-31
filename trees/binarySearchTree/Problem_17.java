// Replace every element with the least greater element on its right

class Problem_17 {
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
    static Node insert(Node node, int key, Wrapper succ) {
        // If the tree is empty, return a new node
        if (node == null) {
            return new Node(key);
        }

        // If key is smaller than node's key, go to left subtree
        if (key < node.data) {
            succ.node = node; // Update successor
            node.left = insert(node.left, key, succ);
        }
        // If key is greater than or equal to node's key, go to right subtree
        else {
            node.right = insert(node.right, key, succ);
        }
        return node;
    }

    // Wrapper class to hold successor node
    static class Wrapper {
        Node node;
    }

    // Function to replace every element with the least greater element on its right
    static void replaceWithLeastGreater(int[] arr) {
        Node root = null;

        // Traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            Wrapper succ = new Wrapper();
            root = insert(root, arr[i], succ);

            // Replace arr[i] with its successor if it exists
            arr[i] = (succ.node != null) ? succ.node.data : -1;
        }
    }

    // Driver method to test above methods
    public static void main(String args[]) {
        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        replaceWithLeastGreater(arr);
        System.out.println("Modified array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}