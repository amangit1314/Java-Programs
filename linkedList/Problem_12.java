package linkedList;

public class Problem_12 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head; // Assuming a single head for the merged list

    public static void main(String[] args) {

        // Sample linked lists
        Problem_12.head = insert(head, 7);
        Problem_12.head = insert(head, 5);
        Problem_12.head = insert(head, 3);
        Problem_12.head = insert(head, 1);

        Node sortedHead = mergeSort(head);
        printList(sortedHead);
    }

    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    static Node getMiddle(Node head) {
        if (head == null || head.next == null) {
            return head; // Handle empty or single-node lists
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head; // Handle empty or single-node lists
        }

        Node middle = getMiddle(head);
        Node right = middle.next;
        middle.next = null; // Separate the lists

        Node left = mergeSort(head); // Recursive call for the left half
        Node rightSorted = mergeSort(right); // Recursive call for the right half

        return merge(left, rightSorted); // Merge the sorted halves
    }

    static Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        // Merge the linked lists in sorted order
        Node mergedHead = (left.data < right.data) ? left : right;
        Node current = mergedHead;

        while (left != null && right != null) {
            if (left.data < right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Append the remaining elements (if any)
        current.next = (left != null) ? left : right;

        return mergedHead;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
