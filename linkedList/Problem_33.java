// Segregate even and odd nodes in a linked list
class Problem_33 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static Node segregateEvenOdd(Node head) {
        if (head == null) {
            return null;
        }

        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;
        Node curr = head;

        while (curr != null) {
            int val = curr.data;

            if (val % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }

            curr = curr.next;
        }

        if (evenStart == null || oddStart == null) {
            return head;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }
}