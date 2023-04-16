// Problem Title - Reverse a Doubly Linked List

public class Problem_19 {

    node head = null;
    // node a, b;
    static class node {
        int val;
        node next;
        node prev;

        public node(int val) {
            this.val = val;
        }
    }

    node reverse(node head) {
        node temp = null;
        node curr = head;

        while(curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if(temp != null)
            head = temp.prev;
        return head;
    }

    static node reverseDLL(node head) {
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        int count = 1;
        node tail = head;

        while(tail.next != null) {
            tail = tail.next; count++;
        }

        node start = head;
        int i = 1;

        while(i <= count/2) {
            int temp = start.val;
            start.val = tail.val;
            tail.val = temp;
            start = start.next;
            tail = tail.prev;
            i++;
        }

        return head;
    }

    // Utility function to print the linked linkedList.list
    void printList(node headref) {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }

    public static void main(String[] args) {
        Problem_20 li = new Problem_20();
        li.head = new node(1);
        li.head.next = new node(2);
        li.head.next.next = new node(3);
        li.head.next.next.next = new node(4);
        li.head.next.next.next.next = new node(5);
        li.head.next.next.next.next.next = li.head;
        li.printList(li.head);
        System.out.println();
        li.head = li.reverse(li.head);
        li.printList(li.head);
    }
}