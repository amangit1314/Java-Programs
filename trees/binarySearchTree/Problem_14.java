package trees.binarySearchTree;

// Problem Title -> Count pairs from 2 BST whose sum is equal to given value "X"
public class Problem_14 {
    // A binary tree node
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root1, root2;

    // Function to count pairs from two BSTs whose sum is equal to given value x
    static int countPairs(Node root1, Node root2, int x) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        java.util.Stack<Node> stack1 = new java.util.Stack<>();
        java.util.Stack<Node> stack2 = new java.util.Stack<>();

        Node curr1 = root1;
        Node curr2 = root2;
        int count = 0;

        // Traverse the first BST in inorder and store its elements in a set
        while (curr1 != null || !stack1.isEmpty()) {
            while (curr1 != null) {
                stack1.push(curr1);
                curr1 = curr1.left;
            }
            curr1 = stack1.pop();
            set.add(curr1.data);
            curr1 = curr1.right;
        }

        // Traverse the second BST in reverse inorder and check for pairs
        while (curr2 != null || !stack2.isEmpty()) {
            while (curr2 != null) {
                stack2.push(curr2);
                curr2 = curr2.right;
            }
            curr2 = stack2.pop();
            if (set.contains(x - curr2.data)) {
                count++;
            }
            curr2 = curr2.left;
        }

        return count;
    }

    // Driver method to test above methods
    public static void main(String args[]) {
        Problem_14 tree1 = new Problem_14();
        tree1.root1 = new Node(5);
        tree1.root1.left = new Node(3);
        tree1.root1.right = new Node(7);
        tree1.root1.left.left = new Node(2);
        tree1.root1.left.right = new Node(4);
        tree1.root1.right.left = new Node(6);
        tree1.root1.right.right = new Node(8);

        Problem_14 tree2 = new Problem_14();
        tree2.root2 = new Node(10);
        tree2.root2.left = new Node(6);
        tree2.root2.right = new Node(15);
        tree2.root2.left.left = new Node(3);
        tree2.root2.left.right = new Node(8);
        tree2.root2.right.left = new Node(12);
        tree2.root2.right.right = new Node(18);

        int x = 16;
        int result = countPairs(tree1.root1, tree2.root2, x);
        System.out.println("Count of pairs is " + result);
    }
}