// Largest BST in a Binary Tree [VVVVV Imp]

class Problem_21 {
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

    // Function to find the size of the largest BST in a binary tree
    static class Info {
        int size; // Size of the subtree
        int min;  // Minimum value in the subtree
        int max;  // Maximum value in the subtree
        int ans;  // Size of the largest BST
        boolean isBST; // Is the subtree a BST

        Info(int size, int min, int max, int ans, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.ans = ans;
            this.isBST = isBST;
        }
    }

    static Info largestBSTUtil(Node node) {
        // An empty tree is a BST of size 0
        if (node == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        // Leaf node is a BST of size 1
        if (node.left == null && node.right == null) {
            return new Info(1, node.data, node.data, 1, true);
        }

        // Recur for left and right subtrees
        Info leftInfo = largestBSTUtil(node.left);
        Info rightInfo = largestBSTUtil(node.right);

        // Create a new Info for the current node
        Info curr = new Info(0, 0, 0, 0, false);
        curr.size = 1 + leftInfo.size + rightInfo.size;

        // Check if the current subtree is a BST
        if (leftInfo.isBST && rightInfo.isBST &&
            leftInfo.max < node.data && rightInfo.min > node.data) {
            curr.min = Math.min(leftInfo.min, Math.min(rightInfo.min, node.data));
            curr.max = Math.max(rightInfo.max, Math.max(leftInfo.max, node.data));
            curr.ans = curr.size;
            curr.isBST = true;
            return curr;
        }

        // If not a BST, return the maximum size of BST found in the subtrees
        curr.ans = Math.max(leftInfo.ans, rightInfo.ans);
        curr.isBST = false;
        return curr;
    }

    static int largestBST(Node node) {
        return largestBSTUtil(node).ans;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 60);
        insert(root, 5);
        insert(root, 20);
        insert(root, 45);
        insert(root, 70);
        insert(root, 65);
        insert(root, 80);

        System.out.println("Size of the largest BST is " + largestBST(root));
    }
}