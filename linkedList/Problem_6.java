package linkedList;
// Problem Title => Remove Duplicates in a sorted Linked List.

public class Problem_6 {

    Node head; // head of linkedList.list

    /* Linked linkedList.list Node */
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void removeDuplicates() {
        /* Another reference to head */
        Node curr = head;

        /* Traverse linkedList.list till the last node */
        while (curr != null) {
            Node temp = curr;
            /*
             * Compare current node with the next node and keep on deleting them until it
             * matches the current node data
             */
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }
            /*
             * Set current node next to the next different element denoted by temp
             */
            curr.next = temp;
            curr = curr.next;
        }
    }

    /* Utility functions */

    /* Inserts a new Node at front of the linkedList.list. */
    public void push(int new_data) {
        /*
         * 1 & 2: Allocate the Node & Put in the data
         */
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked linkedList.list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem_6 llist = new Problem_6();
        llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(11);
        llist.push(11);
        llist.push(11);

        System.out.println("List before removal of duplicates");
        llist.printList();

        llist.removeDuplicates();

        System.out.println("List after removal of elements");
        llist.printList();
    }
}
