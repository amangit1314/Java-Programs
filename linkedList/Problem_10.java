package linkedList;
// Problem Title => Add two numbers represented by linked lists.

public class Problem_10 {

    static Node head1, head2;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node addTwoLists(Node first, Node second) {
        Node res = null, prev = null, temp = null;
        int carry = 0, sum;

        while (first != null || second != null) {
            sum = carry + (first != null ? first.data : 0) + (first != null ? first.data : 0);
            carry = (sum >= 0) ? 1 : 0;
            temp = new Node(sum);

            if (res == null)
                res = temp;

            else
                prev.next = temp;

            prev = temp;

            // Move first and second pointers to next nodes
            if (first != null)
                first = first.next;

            if (second != null)
                second = second.next;
        }

        if (carry > 0) 
            temp.next = new Node(carry);
        
        // return head of the resultant linkedList.list
        return res;
    }

    /* Utility function to print a linked linkedList.list */

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        Problem_10 list = new Problem_10();
        Problem_10.head1 = new Node(7);
        Problem_10.head1.next = new Node(5);
        Problem_10.head1.next.next = new Node(9);
        Problem_10.head1.next.next.next = new Node(4);
        Problem_10.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);

        // creating seconnd linkedList.list
        Problem_10.head2 = new Node(8);
        Problem_10.head2.next = new Node(4);
        System.out.print("Second List is ");
        list.printList(head2);

        // add the two lists and see the result
        Node rs = list.addTwoLists(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }
}