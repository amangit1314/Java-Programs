// Delete nodes which have a greater value on right side
class Problem_32 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    boolean rightPlace(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        if (!rightPlace(head.next)) {
            return false;
        }

        if (head.data < head.next.data) {
            head.data = head.next.data;
            head.next = head.next.next;
            return false;
        }

        return true;
    }

    static Node deleteNodesWithGreaterValueOnRight(Node head) {
        if (head == null) {
            return null;
        }

        Problem_32 list = new Problem_32();

        while (!list.rightPlace(head)) {
            // keep calling until all nodes are in right place
        }

        return head;
    }

    
}