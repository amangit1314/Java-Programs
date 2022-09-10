package trees.binaryTree;

import java.util.HashMap;

/* Problem Title :- Construct Binary tree from Inorder and preorder traversal */
public class BT_Problem_21 {

    static class Node {
        char data;
        Node left, right;
        Node(char item) {
            data = item;
            left = right = null;
        }
    }
    public static Node root;

    // Store indexes of all items so that we can quickly find later
    static HashMap<Character,Integer> mp = new HashMap<>();
    static int preIndex = 0;

    /* Recursive function to construct binary of size len from Inorder traversal in[]
      and Preorder traversal pre[].
      Initial values of inStart and inEnd should be0 and len -1.
      The function doesn't do any error checking for cases where inorder
      and preorder do not form a tree */
    public static Node buildTree(char[] in, char[] pre, int inStart, int inEnd) {

        if(inStart > inEnd) {
            return null;
        }

        /* Pick current node from Preorder traversal using preIndex and increment preIndex */
        char curr = pre[preIndex++];
        Node tNode;
        tNode = new Node(curr);

        /* If this node has no children then return */
        if (inStart == inEnd) {
            return tNode;
        }

        /* Else find the index of this node in Inorder traversal */
        int inIndex = mp.get(curr);

        /* Using index in Inorder traversal, construct left and right subtree's */
        tNode.left = buildTree(in, pre, inStart, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
        return tNode;
    }

    // This function mainly creates an unordered_map, then calls buildTree()
    public static Node buldTreeWrap(char[] in, char[] pre, int len) {
        for(int i = 0; i < len; i++)
            mp.put(in[i], i);
        return buildTree(in, pre, 0, len - 1);
    }

    /* This function is here just to test buildTree() */
    static void printInorder(Node node) {
        if(node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
        char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;

        root = buldTreeWrap(in, pre, len);

        /* Let us test the built tree by printing Inorder traversal */
        System.out.println("Inorder traversal of the constructed tree is");
        printInorder(root);
    }
}

// TIME COMPLEXITY :- O(N)
