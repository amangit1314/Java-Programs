package linkedList;

// Problem Title => Write a program to Detect & Remove loop in a linked linkedList.list.
// Java program to detect and remove loop in linked linkedList.list

public class Problem_4 {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function that detects loop in the linkedList.list
    void detectAndRemoveLoop(Node node) {

        Node slow = node, fast = node;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return;
            }
        }
    }

    // Function to remove loop
    void removeLoop(Node loop, Node curr) {
        Node ptr1, ptr2 = null;

		/* Set a pointer to the beginning of the Linked List
		and move it one by one to find the first node which
		is part of the Linked List */
        ptr1 = curr;
        while (true) {

			/* Now start a pointer from loop_node and check if it ever reaches ptr2 */
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1)
                ptr2 = ptr2.next;

			/* If ptr2 reached ptr1 then there is a loop.
			 So break the loop */
            if (ptr2.next == ptr1)
                break;

            /* If ptr2 did not reach ptr1 then try the next node after ptr1 */
            ptr1 = ptr1.next;
        }

		/* After the end of loop ptr2 is the last node of
		the loop. So make next of ptr2 as NULL */
        ptr2.next = null;
    }

    // Function to print the linked linkedList.list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Driver code
    public static void main(String[] args) {
        Problem_4 list = new Problem_4();
        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;

        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}

// This code has been contributed by Aman Soni


// Time Complexity => O(n).
// Space Complexity => O(n).