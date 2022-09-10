package trees.binaryTree;
// Problem Title => Sum of Nodes on the Longest path from root to leaf node
public class BT_Problem_26 {

    // Node of a binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int maxLen;
    static int maxSum;

    // function to find the sum of nodes on the longest path from root to leaf node
    static void sumOfLongRootToLeafPath(Node root, int sum, int len) {
        // if true, then we have traversed a root to leaf path
        if (root == null) {
            // update maximum length and maximum sum
            // according to the given conditions
            if (maxLen < len) {
                maxLen = len;
                maxSum = sum;
            } else if (maxLen == len && maxSum < sum)
                maxSum = sum;
            return;
        }


        // recur for left subtree
        sumOfLongRootToLeafPath(root.left, sum + root.data, len + 1);

        sumOfLongRootToLeafPath(root.right, sum + root.data, len + 1);

    }

    // utility function to find the sum of nodes on the longest path from root to leaf node
    static int sumOfLongRootToLeafPathUtil(Node root) {
        // if tree is NULL, then sum is 0
        if (root == null)
            return 0;

        maxSum = Integer.MIN_VALUE;
        maxLen = 0;

        // finding the maximum sum 'maxSum' for the maximum length root to leaf path
        sumOfLongRootToLeafPath(root, 0, 0);

        // required maximum sum
        return maxSum;
    }

    // Driver program to test above
    public static void main(String args[]) {
        // binary tree formation
        Node root = new Node(4);         /*        4        */
        root.left = new Node(2);         /*       / \       */
        root.right = new Node(5);        /*      2   5      */
        root.left.left = new Node(7);    /*     / \ / \     */
        root.left.right = new Node(1);   /*    7  1 2  3    */
        root.right.left = new Node(2);   /*      /          */
        root.right.right = new Node(3);  /*     6           */
        root.left.right.left = new Node(6);

        System.out.println( "Sum = " + sumOfLongRootToLeafPathUtil(root));
    }
}
