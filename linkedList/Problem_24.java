// Rotate a DLL in group of given size [V.Imp]

/**
 * example:
 * ip- 10 <-> 8 <-> 4 <-> 12 <-> 15 <-> 20 <-> 25 <-> 30, k = 3
 * op- 4 <-> 8 <-> 10 <-> 25 <-> 20 <-> 15 <-> 30 <-> 12
 */

package linkedList;
class Problem_24 {
    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    static Node head;

    static void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    static Node reverseInGroupOfGivenSize(Node head, int k) {
        if(head == null) return null;

        Node curr = head;
        Node newHead = null;
        Node next = null;
        Node prev = null;
        int count = 0;

        // reverse first k nodes
        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
            count++;
        }

        // next is now pointing to (k+1)th node
        if(next != null) {
            head.next = reverseInGroupOfGivenSize(next, k);
            if(head.next != null) {
                head.next.prev = head;
            }
        }

        return prev; // new head of the reversed group
    }

}