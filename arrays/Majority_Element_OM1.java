package arrays;
// Find majority element in arrays.array Using Binary Search Tree
public class Majority_Element_OM1 {

    static class Node{
        int key;
        int c = 0;
        Node left, right;
    }

    static int ma = 0;

    static Node newNode(int item){
        Node temp = new Node();
        temp.key = item;
        temp.c = 1;
        temp.left = temp.right = null;
        return temp;
    }

    // A utility function to insert a new node with given key in BST
    static Node insert(Node node, int key) {
        // If the tree is empty, return a new node
        if (node == null) {
            if (ma == 0)
                ma = 1;

            return newNode(key);
        }

        // Otherwise, recur down the tree
        if (key < node.key)
            node.left = insert(node.left, key);

        else if (key > node.key)
            node.right = insert(node.right, key);

        else
            node.c++;

        // Find the max count
        ma = Math.max(ma, node.c);

        // Return the (unchanged) node pointer
        return node;
    }

    // A utility function to do inorder traversal of BST
    static void inorder(Node root, int s) {
        if (root != null) {
            inorder(root.left, s);

            if (root.c > (s / 2))
                System.out.println(root.key + "\n");

            inorder(root.right, s);
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 3, 3, 2 };
        int size = a.length;
        Node root = null;

        for (int j : a) {
            root = insert(root, j);
        }

        // Function call
        if (ma > (size / 2))
            inorder(root, size);

        else
            System.out.println("No majority element\n");
    }
}