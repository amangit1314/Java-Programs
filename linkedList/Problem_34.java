// SProgram for nth node from end of linked list
class Problem_34 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static int getNthFromLast(Node head, int n) {
        Node mainPtr = head;
        Node refPtr = head;

        int count = 0;
        if (head != null) {
            while (count < n) {
                if (refPtr == null) {
                    return -1;
                }
                refPtr = refPtr.next;
                count++;
            }

            while (refPtr != null) {
                mainPtr = mainPtr.next;
                refPtr = refPtr.next;
            }
        }

        if (mainPtr != null) {
            return mainPtr.data;
        }

        return -1;
    }
}