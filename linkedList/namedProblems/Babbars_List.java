package linkedList;

import java.util.Scanner;

public class Babbars_List {

//   Static Node class
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

//    Head node
    Node head;

//    Insert at Head
    void insertAtHead(int d){
        Node temp = new Node(d);
        temp.next = head;
        head = temp;
    }

//    Insert at Tail {Error Here}
    void insertAtTail(int d){
        Node newNode = new Node(0);
        newNode.data = d;
        newNode.next = null;
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }

// Insert at specific position
    void insertAtPosition(int position, int d){
//        Insert at head
        if(position == 1){
            insertAtHead(d);
            return;
        }

        Node temp = head;
        int cnt = 1;

//        Insert at position
        while(cnt < position-1){
            temp = temp.next;
            cnt++;
        }

//        Creating a node for d
        Node nodeToInsert = new Node(d);
        nodeToInsert.next = temp.next;
        temp.next = nodeToInsert;

    }

    //  TO print or traverse the linkedList
    void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

//    Delete Node
    void deleteNode(int position){
        Node temp = head, prev = null;
        if(position == 1 && temp != null){
             head = temp.next;
//             memory free start node
            return;
        }

        else{
//            deleting any middle or last node
        }
    }

//    void delteFromStart(){
//        if(head == null){
//            System.out.println("List is empty");
//            return;
//        }
//        else{
//            if(head != tail)
//                head = head.next;
//
//            else
//                head = tail = null;
//
//        }
//    }

//    Main Function
    public static void main(String[] args) {
        Babbars_List bl = new Babbars_List();
        Scanner sc = new Scanner(System.in);

        bl.insertAtHead(39);
//        bl.insertAtTail(41);
        bl.print();

        System.out.println("Enter position -> ");
        int position = sc.nextInt();
        System.out.println("Enter data -> ");
        int d = sc.nextInt();
        bl.insertAtPosition(position, d);
        bl.insertAtTail(d);
        bl.print();
    }
}

// Insertion (done)
// Traversal (done)
// Deletion (pending)