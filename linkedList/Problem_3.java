package linkedList;

import java.util.HashSet;

// Problem Title => Write a program to Detect loop in a linked linkedList.list.
public class Problem_3 {

    static Node head;

    //class to construct or make a Node
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    // function to add linked linkedList.list node
    public static void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // function to detect loop in linked linkedList.list
    static boolean detectLoop(Node head){
        HashSet<Node> hashSet = new HashSet<>();
        while(head != null){
            if(hashSet.contains(head))
                return true;
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;

        if (detectLoop(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }
}

// Time Complexity => O(n).
// Space Complexity => O(n).