package trees.binarySearchTree;

// Problem Title -> Construct bst from preorder traversal
public class Problem_8 {

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

    static int index = 0;
    static Node constructBSTUtil(int pre[], int key,
                                 int min, int max, int size) {
        // Base case
        if (index >= size) {
            return null;
        }

        Node root = null;

        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) {
            // Allocate memory for root of this subtree and increment index
            root = new Node(key);
            index = index + 1;

            if (index < size) {
                // Construct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                root.left = constructBSTUtil(pre, pre[index],
                        min, key, size);
            }
            if (index < size) {
                // All nodes which are in range {key..max} will go in right
                root.right = constructBSTUtil(pre, pre[index],
                        key, max, size);
            }
        }
        return root;
    }

    static Node constructBST(int pre[], int size) {
        return constructBSTUtil(pre, pre[0],
                Integer.MIN_VALUE,
                Integer.MAX_VALUE, size);
    }

    // A utility function to print inorder traversal of BST
    static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Problem_8 tree = new Problem_8();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = constructBST(pre, size);
        System.out.println("Inorder traversal of the constructed BST:");
        printInorder(root);
    }
}