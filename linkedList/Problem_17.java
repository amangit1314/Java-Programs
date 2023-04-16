// Problem Title - Write a program to check whether the sll is a palindrome or note

public class Problem_17 {

    node head = null;
    // node a, b;
    static class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    boolean isPalindrome(node head) {
        node slow = head;
        node fast = head;

        if(head == null)
            return false;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        node secondHalf = slow.next;
        slow.next = null;

        node prev = null;
        node curr = secondHalf;
        node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        secondHalf = prev;

        node temp1 = head;
        node temp2 = secondHalf;

        while(temp1 != null && temp2 != null) {
            if(temp1.val != temp2.val)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    // Utility function to print the linked linkedList.list
    void printList(node headref) {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }

    public static void main(String[] args) {
        Problem_17 li = new Problem_17();
        li.head = new node(1);
        li.head.next = new node(2);
        li.head.next.next = new node(3);
        li.head.next.next.next = new node(4);
        li.head.next.next.next.next = new node(3);
        li.head.next.next.next.next.next = new node(2);
        li.head.next.next.next.next.next.next = new node(1);
        System.out.println(li.isPalindrome(li.head));
    }
}