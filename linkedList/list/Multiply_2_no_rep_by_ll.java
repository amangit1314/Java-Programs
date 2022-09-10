package linkedList.list;

public class Multiply_2_no_rep_by_ll {

    static class Node {
        int data;
        Node next;
    };

    static Node newNode(int data) {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }

    static Node push(Node head_ref, int new_data) {
        Node new_node = newNode(new_data);
        new_node.next = (head_ref);
        (head_ref) = new_node;
        return head_ref;
    }

    static long mul2Lists(Node first, Node second) {
        int num1 = 0, num2 = 0;

        while (first != null || second != null) {
            if (first != null) {
                num1 = num1 * 10;
                first = first.next;
            }
            if (second != null) {
                num2 = num2 * 10 + second.data;
                second = second.next;
            }
        }
        return num1 * num2;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.printf("%d", node.data);
            if (node.next != null)
                System.out.printf("->");
            node = node.next;
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        Node first = null;
        Node second = null;
        first = push(first, 6);
        first = push(first, 4);
        first = push(first, 9);
        System.out.printf("First linkedList.list is: ");
        printList(first);

        second = push(second, 4);
        second = push(second, 8);
        System.out.printf("Second linkedList.list is: ");
        printList(second);

        System.out.printf("Result is: ");
        System.out.println(mul2Lists(first, second));
    }
}
