package linkedList;
// Problem Title => Intersection of two Sorted Linked List.
public class Problem_11 {

    static Node a = null, b = null;

    static Node dummy = null;
    static Node tail = null;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    void printList(Node start){
        Node p = start;
        while(p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    // inserting elements into linkedList.list
    void push(int data) {
        Node temp = new Node(data);
        if(dummy == null) {
            dummy = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            tail = temp;
        }
    }

    // function for finding intersection and adding it to dummy linkedList.list
    void sortedIntersect() {

        // pointers for iterating
        Node p = a,q = b;
        while(p != null  &&  q != null) {
            if(p.data == q.data) {
                // add to dummy linkedList.list
                push(p.data);
                p = p.next;
                q = q.next;
            }
            else if(p.data < q.data)
                p = p.next;
            else
                q= q.next;
        }
    }

    public static void main(String[] args) {
        Problem_11 list = new Problem_11();

        // creating first linked linkedList.list
        list.a = new Node(1);
        list.a.next = new Node(2);
        list.a.next.next = new Node(3);
        list.a.next.next.next = new Node(4);
        list.a.next.next.next.next = new Node(6);

        // creating second linked linkedList.list
        list.b = new Node(2);
        list.b.next = new Node(4);
        list.b.next.next = new Node(6);
        list.b.next.next.next = new Node(8);

        // function call for intersection
        list.sortedIntersect();

        // print required intersection
        System.out.println("Linked linkedList.list containing common items of a & b");
        list.printList(dummy);
    }
}
