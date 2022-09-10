package trees.binaryTree;
//Problem Title => Check if all leaf nodes are at same level or not
public class BT_Problem_23 {

    // Class to create Node of tree
    static class Node{
        int data;
        Node left,right;
        Node(int item){
            this.data = item;
            left = right = null;
        }
    }

    // static leaf class
    static class Leaf{
        int leafLevel = 0;
    }

    Node root;
    Leaf myLevel = new Leaf();

    // recursive function to check
    boolean checkUtil(Node node, int level, Leaf leafLevel){
        //base case
        if(node == null)
            return true;

        if(node.left == null && node.right == null){
            // When a leaf node is found first time
            if (leafLevel.leafLevel == 0){
                // Set first found leaf's level
                leafLevel.leafLevel = level;
                return true;
            }
            // If this is not first leaf node, compare its level with first leaf's level
            return (level == leafLevel.leafLevel);
        }

        // If this node is not leaf, recursively check left and right subtrees
        return checkUtil(node.left, level + 1, leafLevel)
                && checkUtil(node.right, level + 1, leafLevel);
    }

    // Function to check which uses checkUtil()
    boolean check(Node node){
        int level = 0;
        return checkUtil(node, level, myLevel);
    }

    // Driver Function
    public static void main(String[] args) {

        BT_Problem_23 tree = new BT_Problem_23();

        tree.root = new Node(12);
        tree.root.left = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(9);
        tree.root.left.left.left = new Node(1);
        tree.root.left.right.left = new Node(1);

        if (tree.check(tree.root))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }
}
