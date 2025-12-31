// Sort a k sorted DLL

/**
 * example:
 * ip- 3 <-> 6 <-> 2 <-> 12 <-> 56 <-> 8, k = 2
 * op- 2 <-> 3 <-> 6 <-> 8 <-> 12 <-> 56
 */

package linkedList;
class Problem_22 {
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

   static Node sortAKSortedDLL(Node head, int k) {
        if(head == null) return head;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(k + 1, Comparator.comparingInt(a -> a.data));

        Node newHead = null, last = null;
        for(int i = 0; head != null && i <= k; i++) {
            minHeap.add(head);
            head = head.next;
        }

        while(!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            if(newHead == null) {
                newHead = curr;
                newHead.prev = null;
                last = newHead;
            } else {
                last.next = curr;
                curr.prev = last;
                last = curr;
            }

            if(head != null) {
                minHeap.add(head);
                head = head.next;
            }
        }

        last.next = null;
        return newHead;
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