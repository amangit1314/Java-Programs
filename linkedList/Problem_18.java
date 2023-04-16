//  Problem Title - Deletion from a circular linked list

public class Problem_18 {

    node head = null;
    // node a, b;
    static class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    static node deleteNode(node head, int key) {
        if(head == null)
            return;
        node curr = head, prev = new node();

        while(curr.data != key) {
            if(curr.next == head) {
                System.out.println("Key not found");
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        if(curr == head && cirr.next == head) {
            head == null;
            return head;
        }

        if(curr == head) {
            prev = head;
            while(prev.next != head) {
                prev = prev.next;
                head = curr.next;
                prev.next = head;
            }
        }

        else if(curr.next == head)
            prev.next = head;
        else
            prev.next = curr.next;

        return head;
    }

    // Utility function to print the linked linkedList.list
    void printList(node headref) {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }

    public static void main(String[] args) {
        Problem_18 li = new Problem_18();
        li.head = new node(1);
        li.head.next = new node(2);
        li.head.next.next = new node(3);
        li.head.next.next.next = new node(4);
        li.head.next.next.next.next = new node(5);
        li.head.next.next.next.next.next = li.head;
        li.deleteNode(5);
        li.printList(li.head);
    }
}

//  Time - O(n)
//  Space - O(1)