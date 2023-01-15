package stack_and_queue;

// Check if all levels of two trees are anagrams or not.

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class P34 {

    public static boolean areAnagrams(Node node1, Node node2) {
        if(node1 == null && node2 == null)
            return true;

        if(node1 == null || node2 == null)
            return false;

        if(node1.data != node2.data)
            return false;

        return areAnagrams(node1.left, node2.right) && areAnagrams(node1.right, node2.left);
    }

    public static void main(String[] args) {

    }
}