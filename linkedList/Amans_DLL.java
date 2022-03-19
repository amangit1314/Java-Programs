package linkedList;

public class Amans_DLL {

    private Node head;

    private static class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val){
            this.val = val;
        }

        public Node(Node prev, Node next, int val){
            this.val = val;
            this.prev = prev;
            this.next= next;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null)
            head.prev = node;
        head = node;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;

        node.next = null;

        if (head == null){
            node.prev = null;
            head = node;
            return;
        }

        while(last.next != null){
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public Amans_DLL.Node get(int index){
        Amans_DLL.Node node = head;
        for(int i = 0; i <index; i++){
            node = node.next;
        }
        return node;
    }

    public Amans_DLL.Node find(int val){
        Amans_DLL.Node node = head;
        while (node != null){
            if(node.val == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insertAtPosition(int after, int val){

        Node p = find(after);
        if(p == null){
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null)
            node.next.prev = node;

    }

    public void display(){
        Node node = head;
        Node last = null;
        while (node != null){
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");
        while (last != null){
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

}