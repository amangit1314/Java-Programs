package trees.binarySearchTree;

// Problem Title -> Merge two bst
public class Problem_11 {
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

    // A utility function to store inorder traversal of BST
    static void storeInorder(Node node, int inorder[], Index index) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        storeInorder(node.left, inorder, index);

        // Store the data of node
        inorder[index.index] = node.data;
        index.index++;

        // Traverse the right subtree
        storeInorder(node.right, inorder, index);
    }

    // A utility function to merge two sorted arrays into one
    static int[] merge(int arr1[], int arr2[]) {
        int m = arr1.length;
        int n = arr2.length;
        int arr3[] = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i < m && j < n) {
            // Check if current element of first array is smaller than current element of second array.
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        // Store remaining elements of first array
        while (i < m) {
            arr3[k++] = arr1[i++];
        }

        // Store remaining elements of second array
        while (j < n) {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }

    // A utility function to construct balanced BST from sorted array
    static Node sortedArrayToBST(int arr[], int start, int end) {
        // Base Case
        if (start > end) {
            return null;
        }

        // Get the middle element and make it root
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        // Recursively construct the left subtree and make it left child of root
        node.left = sortedArrayToBST(arr, start, mid - 1);

        // Recursively construct the right subtree and make it right child of root
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    // This function merges two balanced BSTs
    static Node mergeTrees(Node root1, Node root2) {
        // Store inorder traversal of first tree in an array
        int n1 = countNodes(root1);
        int arr1[] = new int[n1];
        Index index1 = new Index();
        index1.index = 0;
        storeInorder(root1, arr1, index1);

        // Store inorder traversal of second tree in another array
        int n2 = countNodes(root2);
        int arr2[] = new int[n2];
        Index index2 = new Index();
        index2.index = 0;
        storeInorder(root2, arr2, index2);

        // Merge the two sorted arrays into one
        int mergedArr[] = merge(arr1, arr2);

        // Construct balanced BST from the merged sorted array
        return sortedArrayToBST(mergedArr, 0, mergedArr.length - 1);
    }

    // Function to count number of nodes in binary tree
    static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    // Utility class to hold index value
    static class Index {
        int index;
    }

    // A utility function to do inorder traversal of BST
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
        // Let us create the first BST shown in the above figure
        Node root1 = new Node(100);
        root1.left = new Node(50);
        root1.right = new Node(300);
        root1.left.left = new Node(20);
        root1.left.right = new Node(70);

        // Let us create the second BST shown in the above figure
        Node root2 = new Node(80);
        root2.left = new Node(40);
        root2.right = new Node(120);

        // Merge the two BSTs
        Node mergedRoot = mergeTrees(root1, root2);

        // Print inorder traversal of the merged BST
        System.out.println("Inorder traversal of the merged BST is:");
        printInorder(mergedRoot);
    }
}