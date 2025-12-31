// Flatten a linked list

class Problem_27 {
    static class Node {
        int data;
        Node next, bottom;

        Node(int data) {
            this.data = data;
            this.next = this.bottom = null;
        }
    }

    static Node head;

    static Node mergeTwoSortedLists(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = mergeTwoSortedLists(a.bottom, b);
        } else {
            result = b;
            result.bottom = mergeTwoSortedLists(a, b.bottom);
        }

        return result;
    }

    static Node flattenLinkedList(Node root) {
        if (root == null || root.next == null) return root;

        root.next = flattenLinkedList(root.next);

        root = mergeTwoSortedLists(root, root.next);

        return root;
    }
}