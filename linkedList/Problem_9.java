package linkedList;
// Problem Title => Add “1” to a number represented as a Linked List.

public class Problem_9 {

    static class Node {
        int data;
        Node next;
    }

    static Node newNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        return newNode;
    }

    // Recursively add 1 from end to beginning and returns carry after all nodes are processed.
    static int addWithCarry(Node head) {
        // If linked linkedList.list is empty, then return carry
        if (head == null)
            return 1;

        // Add carry returned by next node call
        int res = head.data + addWithCarry(head.next);

        // Update data and return new carry
        head.data = (res) % 10;
        return (res) / 10;
    }

    // This function mainly uses addWithCarry().
    static Node addOne(Node head) {

        // Add 1 to linked linkedList.list from end to beginning
        int carry = addWithCarry(head);

        // If there is carry after processing all nodes,
        // then we need to add a new node to linked linkedList.list
        if (carry > 0) {
            Node newNode = newNode(carry);
            newNode.next = head;
            return newNode; // New node becomes head now
        }

        return head;
    }

    // A utility function to print a linked linkedList.list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    /* Driver code */
    public static void main(String[] args) {
        Node head = newNode(1);
        head.next = newNode(9);
        head.next.next = newNode(9);
        head.next.next.next = newNode(9);

        System.out.print("List is");
        printList(head);

        head = addOne(head);
        System.out.println();
        System.out.print("Resultant linkedList.list is");
        printList(head);
    }

}
