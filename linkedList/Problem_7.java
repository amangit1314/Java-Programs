package linkedList;

// Problem Title => Remove Duplicates in an Un-sorted Linked List.

public class Problem_7 {

    static Node head;

    // structure of node of ll
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // function to remove duplicates
    void remove_duplicates() {
        Node ptr1 = null, ptr2;
        ptr2 = ptr1;

        while (ptr2.next != null && ptr1 != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.data == ptr2.next.data) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else
                    ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }
    
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Problem_7 list = new Problem_7();

        Problem_7.head = new Node(10);
        Problem_7.head.next = new Node(12);
        Problem_7.head.next.next = new Node(11);
        Problem_7.head.next.next.next = new Node(11);
        Problem_7.head.next.next.next.next = new Node(12);
        Problem_7.head.next.next.next.next.next = new Node(11);
        Problem_7.head.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked List before removing duplicates : \n ");
        list.printList(head);

        list.remove_duplicates();
        System.out.println("");
        System.out.println("Linked List after removing duplicates : \n ");
        list.printList(head);    
    }
}
