// Count triplets in a sorted doubly linked list whose sum is equal to a given value x

/**
 * example:
 * ip- 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
 * op - 2
 * explanation: Triplet Found: (2, 6, 9), (4, 5, 8)
 */

package linkedList;
class Problem_21 {
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

    static int countPairs(Node first, Node last, int x) {
        int count = 0;

        while (first != null && last != null && first != last && last.next != first) {
            int currentSum = first.data + last.data;

            if (currentSum == x) {
                count++;
                first = first.next;
                last = last.prev;
            } else if (currentSum < x) {
                first = first.next;
            } else {
                last = last.prev;
            }
        }

        return count;
    }

   static int countTriplets(Node head, int x) {
    if(head == null) return 0;
    Node current, first, last;
    int count = 0;

    last = head;
    while(last .next != null) {
        last = last.next;
    }

    for(current = head; current != null; current = current.next) {
        first = current.next;
        count += countPairs(first, last, x - current.data);
    }

    return count;
   }

    public static void main(String[] args) {
        Problem_21.insert(1);
        Problem_21.insert(2);
        Problem_21.insert(3);
        Problem_21.insert(4);
        Problem_21.insert(5);
        Problem_21.insert(6);
        Problem_21.insert(7);

        int sum = 8;
        System.out.println("Number of triplets: " + Problem_21.countTriplets(head, sum));
    }
}