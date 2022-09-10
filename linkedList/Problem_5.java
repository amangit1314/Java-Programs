package linkedList;

// Problem Title => Find the starting point of the loop. 
public class Problem_5 {
    static class Node{
        int key;
        Node next;
    }

    static Node newNode(int key) {
        Node temp = new Node();
        temp.key = key;
        temp.next = null;
        return temp;
    }

    // A utility function to print a linked linkedList.list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.next;
        }
        System.out.println();
    }

    //Function to detect and remove loop
    // in a linked linkedList.list that may contain loop
    static Node detectAndRemoveLoop(Node head) {
        // If linkedList.list is empty or has
        // only one node without loop
        if (head == null || head.next == null)
            return null;

        Node slow = head, fast = head;

        // Move slow and fast 1
        // and 2 steps ahead
        // respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using
        // slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }

        // If loop does not exist
        if (slow != fast)
            return null;

        // If loop exists. Start slow from
        // head and fast from meeting point.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        Node head = newNode(50);
        head.next = newNode(20);
        head.next.next = newNode(15);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(10);

        // Create a loop for testing
        head.next.next.next.next.next = head.next.next;

        Node res = detectAndRemoveLoop(head);
        if (res == null)
            System.out.print("Loop does not exist");
        else
            System.out.print("Loop starting node is " + res.key);

    }
}