// Rotate a DLL by N nodes

/**
 * example:
 * ip- a <-> b <-> c <-> d <-> e <-> f, N = 2
 * op- e <-> f <-> a <-> b <-> c <-> d
 */

package linkedList;
class Problem_23 {
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

   static Node rotateByN(int pos) {
        if(pos == 0) return;

        Node curr = head;
        while(pos != 0) {
            curr = curr.next;
            pos--;
        }

        Node tail = curr.prev;
        Node newHead = curr;

        tail.next = null;
        curr.prev = null;
        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;
        head.prev = curr;
        head = newHead;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        insert(6);

        int N = 2;
        head = rotateByN(N);

        printList(head);
    }
}