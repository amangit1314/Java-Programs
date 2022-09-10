package stack_and_queue;

// Problem Title => Java Program to implement a stack that supports findMiddle() and deleteMiddle in O(1) time

public class P4 {

    /* A Doubly Linked List Node */
    static class DLLNode {
        DLLNode prev;
        int data;
        DLLNode next;
        // Constructor
        DLLNode(int d) {
            data = d;
        }
    }

     // Representation of the stack data structure that supports findMiddle() in O(1) time.
     // The Stack is implemented using Doubly Linked List.
     // It maintains pointer to head node, pointer to middle node and count of nodes.
    static class myStack {
        DLLNode head;
        DLLNode mid;
        int count;
    }

    /* Function to create the stack data structure */
    myStack createMyStack() {
        myStack ms = new myStack();
        ms.count = 0;
        return ms;
    }

    /* Function to push an element to the stack */
    void push(myStack ms, int new_data) {

        /* allocate DLLNode and put in data */
        DLLNode new_DLLNode = new DLLNode(new_data);

        /*
         * Since we are adding at the beginning, prev is always NULL
         */
        new_DLLNode.prev = null;

        /* link the old linkedList.list off the new DLLNode */
        new_DLLNode.next = ms.head;

        /* Increment count of items in stack */
        ms.count += 1;

        // Change mid_pointer in two cases 1) Linked List is empty 2) Number of nodes in linked linkedList.list is odd
        if (ms.count == 1) 
            ms.mid = new_DLLNode;

        else {
            ms.head.prev = new_DLLNode;

            if ((ms.count % 2) != 0) // Update mid if ms->count is odd
                ms.mid = ms.mid.prev;
        }

        /* move head to point to the new DLLNode */
        ms.head = new_DLLNode;
    }

    /* Function to pop an element from stack */
    int pop(myStack ms) {
        /* Stack underflow */
        if (ms.count == 0) {
            System.out.println("Stack is empty");
            return -1;
        }

        DLLNode head = ms.head;
        int item = head.data;
        ms.head = head.next;

        // If linked linkedList.list doesn't become empty,
        // update prev of new head as NULL
        if (ms.head != null)
            ms.head.prev = null;

        ms.count -= 1;

        // update the mid_pointer when we have even_number of elements in the stack,
        // i,e move down the mid_pointer.
        if (ms.count % 2 == 0)
            ms.mid = ms.mid.next;

        return item;
    }

    // Function for finding middle of the stack
    int findMiddle(myStack ms) {
        if (ms.count == 0) {
            System.out.println("Stack is empty now");
            return -1;
        }
        return ms.mid.data;
    }

    // Driver program to test functions of myStack
    public static void main(String[] args) {
        P4 ob = new P4();
        myStack ms = ob.createMyStack();
        ob.push(ms, 11);
        ob.push(ms, 22);
        ob.push(ms, 33);
        ob.push(ms, 44);
        ob.push(ms, 55);
        ob.push(ms, 66);
        ob.push(ms, 77);

        System.out.println("Item popped is " + ob.pop(ms));
        System.out.println("Item popped is " + ob.pop(ms));
        System.out.println("Middle Element is " + ob.findMiddle(ms));
    }
}
