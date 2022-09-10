package trees.binaryTree;
import java.util.*;

// Problem Title => Maximum Sum of nodes in Binary tree such that no two are adjacent

public class BT_Problem_29 {

    // method returns maximum sum possible from subtrees rooted at grand Children's of node 'node'
    public static int sumOfGrandChildren(Node node, HashMap<Node,Integer> mp) {
        int sum = 0;
        //  call for children of left child only if it is not NULL
        if (node.left!=null)
            sum += getMaxSumUtil(node.left.left, mp) +
                    getMaxSumUtil(node.left.right, mp);

        //  call for children of right child only if it is not NULL
        if (node.right!=null)
            sum += getMaxSumUtil(node.right.left, mp) +
                    getMaxSumUtil(node.right.right, mp);
        return sum;
    }

    //  Utility method to return maximum sum rooted at node 'node'
    public static int getMaxSumUtil(Node node, HashMap<Node,Integer> mp) {
        if (node == null)
            return 0;

        // If node is already processed then return calculated value from map
        if(mp.containsKey(node))
            return mp.get(node);

        //  take current node value and call for all grand children
        int incl = node.data + sumOfGrandChildren(node, mp);

        //  don't take current node value and call for all children
        int excl = getMaxSumUtil(node.left, mp) +
                getMaxSumUtil(node.right, mp);

        //  choose maximum from both above calls and store that in map
        mp.put(node,Math.max(incl, excl));

        return mp.get(node);
    }

    // Returns maximum sum from subset of nodes of binary tree under given constraints
    public static int getMaxSum(Node node) {
        if (node == null)
            return 0;
        HashMap<Node,Integer> mp=new HashMap<>();
        return getMaxSumUtil(node, mp);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left = new Node(1);
        System.out.print(getMaxSum(root));
    }
}