package linkedList;

class Reverse_a_LL {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Reverse_a_LL list = new Reverse_a_LL();
        Reverse_a_LL.head = new Node(85);
        Reverse_a_LL.head.next = new Node(15);
        Reverse_a_LL.head.next.next = new Node(4);
        Reverse_a_LL.head.next.next.next = new Node(20);

        System.out.println("Given Linked linkedList.list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked linkedList.list ");
        list.printList(head);

    }
}

/*
 * output: ! Given Linked List ? 85 15 4 20 ! Reversed Linked List ? 20 4 15 85
 */
