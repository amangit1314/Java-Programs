package linkedList;
// Problem Title => Find Middle of Linked list
public class Problem_14 {
    node head = null;
    // node a, b;
    static class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    public Node middleNode(Node head) {
        int count = 0;
        Node temp = head;

        while(temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = 0;
        if(count % 2 == 0)
            mid = count / 2;
        else
            mid = (count + 1) / 2;

        Node front = head;
        int count2 = 0;

        while(count2 + 1 != m) {
            front = front.next;
            count2++;
        }

        return front;
    }

    // Utility function to print the linked linkedList.list
    void printList(node headref) {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }

    public static void main(String[] args) {
        Problem_14 li = new Problem_14();
        li.head = new node(1);
        li.head.next = new node(2);
        li.head.next.next = new node(3);
        li.head.next.next.next = new node(4);
        li.head.next.next.next.next = new node(5);
        li.head.next.next.next.next.next = new node(6);
        li.head.next.next.next.next.next.next = new node(7);
        li.head.next.next.next.next.next.next.next = new node(8);
        li.head.next.next.next.next.next.next.next.next = new node(9);
        li.head.next.next.next.next.next.next.next.next.next = new node(10);
      
        li.printList(li.head);  
    }
}