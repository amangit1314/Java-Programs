package  linkedList;

class LL{

    // class to create a node of linked linkedList.list
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next  =  null;
        }
    }

    Node head;
    Node position;

    void add(int data) {
        LL.Node toAdd = new LL.Node(data);
        if(isEmpty()) {
            head = toAdd;
            return;
        }
        LL.Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = toAdd;
    }

    boolean isEmpty() {
        return head == null;
    }

    void remove(int data) {
        head = null;
    }

    void print() {
        LL.Node temp = head;
        while(temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    void isValue() {
    }

    public static void main(String[] args) {
        LL l = new LL();
        l.add(7);
        l.add(9);
        l.print();
        l.remove(7);
        l.print();
        l.isValue();
    }
}