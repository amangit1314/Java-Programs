// Sort a linked list of 0s, 1s and 2s

class Problem_28 {
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
}