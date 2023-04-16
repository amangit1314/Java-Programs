package linkedList;
// Problem Title => Quick Sort For Linked lists.[Very Important]
public class Problem_13 {
    node head = null;
    // node a, b;
    static class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    node sortedMerge(node a, node b) {
        node result;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    node quickSort(node h)
    {
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the linkedList.list
        node start = h;
        node end = getEnd(h);

        sort(start, end);

        return node;
    }

    // Utility function to get the middle of the linked linkedList.list
    public static node getEnd(node head)
    {
        Node temp = node;
        while(temp.next != null)
            temp = temp.next;
        return temp;
    }

    public static Node partition(Node start, Node end)
    {
        /* allocate node */
        Node prev  = start;
        Node curr = start;
        int pivot = end.data;

        while(start != end) {
            if(start.data < pivot) {
                prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;
        return prev;
    }

    // Utility function to print the linked linkedList.list
    void printList(node headref)
    {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }

    public static void main(String[] args)
    {

        Problem_13 li = new Problem_13();
        li.head = new node(30);
        li.head.next = new node(3);
        li.head.next.next = new node(4);
        li.head.next.next.next = new node(20);
        li.head.next.next.next.next = new node(5);

        // Apply merge Sort
        li.head = li.quickSort(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
    }
}