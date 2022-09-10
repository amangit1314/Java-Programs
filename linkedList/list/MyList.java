package linkedList.list;

/**
 *   (Head)
 *   ****** ------> ****** ------> ****** ------> ****** ------> ******
 *                                                               (Last Node)
 *                                                               [☝ means next is null]
 * */

public class MyList<E> {

    // creating a node of linked linkedList.list
    public static class Node<E>{
        // data part of linked linkedList.list
        public E data;
        // next node of the linked linkedList.list or next part
        public Node<E> next;

        // constructor
        public Node(E data){
            this.data = data;
            next = null;
        }
    }

    // E is the Class defining the type of the inputs accepted (Generics)
    // Creating new linked linkedList.list node named as head
    MyList.Node<E> head;

    // function to check whether the linked linkedList.list is empty or not
    public boolean isEmpty(){
        return head == null;
    }

    // function to add the new node in the linked linkedList.list
    public void add(E data){
        Node<E> toAdd = new Node<>(data);

        if(isEmpty()){
            head = toAdd;
            return;
        }

        // initialising temp as head to traverse the Linked linkedList.list without breaking the chain
        Node<E> temp = head;

        // control from loop exits as soon as next element becomes null
        while(temp.next != null)
            temp = temp.next;

        // adding the new node after reaching to the end of linked linkedList.list
        temp.next = toAdd;
    }

    // function to removeLat element from linked linkedList.list
    public E removeLast() throws Exception{
        Node<E> temp = head;

        if(temp == null)
            throw new Exception("Cannot remove last element from empty linked linkedList.list");

        if(temp.next == null){
            Node<E> toRemove = head;
            head = null;
            return toRemove.data;
        }

        while(temp.next.next != null)
            temp = temp.next;

        Node<E> toRemove = temp.next;
        // changing the pointer of temp.next from toRemove to null,
        // and garbage collection is done automatically
        temp.next = null;

        return toRemove.data;
    }

    // function to print the element from linked linkedList.list
    void print(){
        Node<E> temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // function to get the last element of the linked linkedList.list
    public E getLast() throws Exception{
        Node<E> temp = head;

        // linkedList.list is empty
        if(temp == null)
            throw new Exception("Cannot peek last element from empty linked linkedList.list");

        while(temp.next != null)
            temp = temp.next;
        return temp.data;
    }

    public static void main(String[] args) {

    }
}