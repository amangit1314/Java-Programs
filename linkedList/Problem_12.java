package linkedList;
// Pronblem Title => Merge Sort for linked lists [Very Important]. 
public class Problem_12 {
    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

static Node mergeSort(Node head) {
    if(head == null || head.next == null)
        return head;

    Node middle = getMiddle(head);
    Node right = middle.next;
    middle.next = null;
    Node left = mergeSort(left);
    Node left1 = mergeSort(left);
    Node left2 = mergeSort(right);
    return merge(left1, left2);
}

static Node getMiddle(Node head) {
    Node slow = head;
    Node fast = head.next;

    while(fasty != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}

static Node merge(Node head1, Node head2) {
    if(head1 == null)
    return head2;

    if(head2 == null)
    return head1;

    if(head1.data < head2.data) {
        head1.next = merge(head1.next, head2);
        return head1;
    } else {
        head2.next = merge(head1, head2.next);
        return head2;
    }
}

    public static void main(String[] args) {
        Problem_12 list = new Problem_12();

        list.head1 = new Node(1);
        list.head1.next = new Node(3);
        list.head1.next.next = new Node(5);
        list.head1.next.next.next = new Node(7);

        list.head2 = new Node(2);
        list.head2.next = new Node(4);
        list.head2.next.next = new Node(6);
        list.head2.next.next.next = new Node(8);

        Node result = mergeSort(head1);
        printList(result);

        
    }
}