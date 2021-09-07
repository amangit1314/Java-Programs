package linkedList;
// Problem Title => Write a Program to Move the last element to Front in a Linked List.
 
public class Problem_8 {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static void moveToFront() {
        if (head == null || head.next == null)
            return;

        Node secLast = null;
        Node last = head;

        while (last.next != null) {
            secLast = last;
            last = last.next;
        }

        secLast.next = null;
        last.next = head;
        head = last;
    }
    
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Problem_8 list = new Problem_8();

        list.push(5);
        list.push(4);
        list.push(8);
        list.push(2);
        list.push(3);

        System.out.println("Linked List before moving last to front ");
        Problem_8.printList();

        Problem_8.moveToFront();

        System.out.println("Linked List after moving last to front ");
        Problem_8.printList();
    
    }    
}
