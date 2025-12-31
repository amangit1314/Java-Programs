// Find Pairs with given sum in Doubly Linked List

package linkedList;
class Problem_20 {
    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    static Node head;

    static void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    static void findPairsWithSum(int sum) {
        Node first = head;
        Node second = head;

        while (second.next != null) {
            second = second.next;
        }

        boolean found = false;

        while (first != null && second != null && first != second && second.next != first) {
            int currentSum = first.data + second.data;

            if (currentSum == sum) {
                System.out.println("Pair Found: (" + first.data + ", " + second.data + ")");
                found = true;
                first = first.next;
                second = second.prev;
            } else if (currentSum < sum) {
                first = first.next;
            } else {
                second = second.prev;
            }
        }

        if (!found) {
            System.out.println("No Pair Found");
        }
    }

    public static void main(String[] args) {
        Problem_20.insert(1);
        Problem_20.insert(2);
        Problem_20.insert(3);
        Problem_20.insert(4);
        Problem_20.insert(5);
        Problem_20.insert(6);
        Problem_20.insert(7);

        int sum = 8;
        Problem_20.findPairsWithSum(sum);
    }
}