package linkedList;
// Problem Title => Check if a Linked list is a circular linked list.[Very Important]
public class Problem_15 {
    node head = null;
    // node a, b;
    static class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    boolean isCircular(Node head) {
        if(head == null)
            return true;
        
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
            if(temp == head)
                return true;
        }
        return false;
    }

    // Utility function to print the linked linkedList.list
    void printList(node headref) {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }

    public static void main(String[] args) {
        Problem_15 li = new Problem_15();
        li.head = new node(1);
        li.head.next = new node(2);
        li.head.next.next = new node(3);
        li.head.next.next.next = new node(4);
        li.head.next.next.next.next = new node(5);
        li.head.next.next.next.next.next = li.head;
        System.out.println(li.isCircular(li.head));
    }
}