// merge k sorted lls

class Problem_30 {
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

    static Node mergeKSortedLists(Node[] lists, int k) {
        if (lists == null || k == 0) return null;

        Node mergedList = null;

        for (int i = 0; i < k; i++) {
            mergedList = mergeTwoSortedLists(mergedList, lists[i]);
        }

        return mergedList;
    }
}