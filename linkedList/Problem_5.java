package linkedList;
import java.util.*;

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

    // A utility function to print a linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Function to detect first node of loop in a linked list that may contain loop
    static Node detectLoop(Node head) {

        // Create a temporary node
        Node temp = new Node();

        while (head != null) {

            // This condition is for the case when there is no loop
            if (head.next == null)
                return null;

            // Check if next is already pointing to temp
            if (head.next == temp)
                break;

            // Store the pointer to the next node in order to get to it in the next step
            Node nex = head.next;

            // Make next point to temp
            head.next = temp;

            // Get to the next node in the list
            head = nex;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }
}