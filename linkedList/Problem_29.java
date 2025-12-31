// Clone a ll with next and random pointer

class Problem_29 {
    static class Node {
        int data;
        Node next, random;

        Node(int data) {
            this.data = data;
            this.next = this.random = null;
        }
    }

    static Node head;

    static Node cloneLinkedList(Node head) {
        if (head == null) return null;

        // Step 1: Create cloned nodes and insert them next to original nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Set random pointers for cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the cloned list from the original list
        curr = head;
        Node clonedHead = head.next;
        Node clonedCurr = clonedHead;

        while (curr != null) {
            curr.next = curr.next.next;
            if (clonedCurr.next != null) {
                clonedCurr.next = clonedCurr.next.next;
            }
            curr = curr.next;
            clonedCurr = clonedCurr.next;
        }

        return clonedHead;
    }
}