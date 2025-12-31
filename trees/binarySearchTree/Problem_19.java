// Check preorder is valid or not

class Problem_19 {
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

    // Function to check if the given preorder traversal is valid for BST
    static boolean isValidPreorder(int[] pre, int n) {
        Node root = null;

        // Insert elements of preorder array into BST
        for (int i = 0; i < n; i++) {
            root = insert(root, pre[i]);
        }

        // Perform inorder traversal of the constructed BST
        int[] inorder = new int[n];
        inorderTraversal(root, inorder, new int[]{0});

        // Check if inorder traversal is sorted
        for (int i = 1; i < n; i++) {
            if (inorder[i] < inorder[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Helper function for inorder traversal
    static void inorderTraversal(Node node, int[] inorder, int[] index) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, inorder, index);
        inorder[index[0]++] = node.data;
        inorderTraversal(node.right, inorder, index);
    }

    // Driver method to test above methods
    public static void main(String args[]) {
        int[] pre1 = {10, 5, 1, 7, 40, 50};
        int n1 = pre1.length;
        if (isValidPreorder(pre1, n1)) {
            System.out.println("Preorder 1 is valid for BST");
        } else {
            System.out.println("Preorder 1 is not valid for BST");
        }

        int[] pre2 = {10, 5, 40, 1};
        int n2 = pre2.length;
        if (isValidPreorder(pre2, n2)) {
            System.out.println("Preorder 2 is valid for BST");
        } else {
            System.out.println("Preorder 2 is not valid for BST");
        }
    }
}