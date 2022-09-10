package trees.binaryTree;
// Problem Title => Check if 2 trees are mirror or not
public class BT_Problem_25 {

    static class Node{
        int data;
        Node left,right;
        Node(int item){
            this.data = item;
            left = right = null;
        }
    }

    Node a, b;

    /* Given two trees, return true if they are mirrors of each other */
    boolean areMirror(Node a, Node b) {
        /* Base case : Both empty */
        if (a == null && b == null)
            return true;

        // If only one is empty
        if (a == null || b == null)
            return false;

        /* Both non-empty, compare them recursively Note that in recursive calls,
        we pass left of one tree and right of other tree */
        return a.data == b.data
                && areMirror(a.left, b.right)
                && areMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        BT_Problem_25 tree = new BT_Problem_25();
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);

        if (tree.areMirror(a, b))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
