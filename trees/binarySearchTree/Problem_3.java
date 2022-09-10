// Problem Tiitle => Find min and max value in a BST

public class Problem_3 {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node head;

    Node insert(Node node, int data) {
        if (node == null)
            return (new Node(data));

        else {
            if (data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);

            return node;
        }
    }
    
    // Returns the min value in a binary tree
    int minValue(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    // Returns the max value in a binary tree
    int maxValue(Node node) {
        if(node == null)
            return Integer.MIN_VALUE;

        int res = node.data;
        int lres = maxValue(node.left);
        int rres = maxValue(node.right);

        if(lres > rres)
            res = lres;

        if(rres > res)
            res = rres;

        return res;
    }

    public static void main(String[] args) {
        Problem_3 tree = new Problem_3();
        Node root = null;
        root = tree.insert(root, 4);
        tree.insert(root, 2);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 6);
        tree.insert(root, 5);

        System.out.println("Minimum value of BST is " + tree.minValue(root));
        System.out.println("Maximum value of BST is " + tree.maxValue(root));

    }
}
