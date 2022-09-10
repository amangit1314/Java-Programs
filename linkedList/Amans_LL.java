package linkedList;

public class Amans_LL {

    private Node head;
    private Node tail;
    private int size;

    public Amans_LL(){
        this.size = 0;
    }

    static private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int val){
            Node node = new Node(val);
            node.next = head;
            head = node;

            if(tail == null)
                tail = head;

            size += 1;
    }

    public void insertLast(int val){

// <---------With using tail-------------->
       if(tail == null){
           insertFirst(val);
           return;
       }
        Node node = new Node(val);
       tail.next = node;
       tail = node;
       size++;
// <-------------------------------------->

// <----------Without using tail---------->
//        Node node = new Node(val);
//        node.value = val;
//        node.next = null;
//        Node temp = head;
//        while(temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = node;
// <------------------------------------->
    }

    public void insertAtPosition(int index, int val){
//        for start position
        if(index == 0){
            insertFirst(val);
            return;
        }

//        for ending position
        if(index == size){
            insertLast(val);
            return;
        }

//        here current = temp
        Node temp = head;
        for (int i = 1; i < index; i++){
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null)
            tail = null;
        size--;
        return val;
    }

    //  insert using recursion
    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index--, node.next);
        return node;
    }

    public int deleteLast(){
            if(size <= 1){
                return deleteFirst();
            }

            Node secondLast = get(size-2);
            int val = tail.value;
            tail = secondLast;
            tail.next = null;
            return val;
    }

    public int delete(int index){
        if(index == 0)
            return deleteFirst();

        if(index == size-1)
            return deleteLast();

        Node prev = get(index -1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        return val;
    }

    public Node get(int index){
        Node node = head;
        for(int i = 0; i <index; i++){
            node = node.next;
        }
        return node;
    }

    public Node find(int value){
        Node node = head;
        while (node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // Question 6 - remove duplicates from sorted linked linkedList.list
    public Node removeSortedDuplicates(){
        if(head == null)
            return null;
        Node curr = head;
        while(curr != null){
            Node temp = curr;
            while (temp != null && temp.value == curr.value)
                temp = temp.next;
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }

    // Question 7 - remove duplicates from un-sorted linked linkedList.list
    public Node removeUnsortedDuplicates(){

        if(head == null)
            return null;
        Node curr = head;
        while(curr != null){
            Node temp = curr;
        }
        return head;
    }

    // Question 5 - find starting of the loop in the linked linkedList.list
    public Node startingOfLoop(){
        if(head == null || head.next == null)
            return null;
        Node slow = head, fast = head;
        // moving slow once and fast twice
        slow = slow.next;
        fast = fast.next.next;
        // search for loop using slow and fast
        while(fast == null && fast.next == null){
            if(slow == fast)    break;
            slow = slow.next;
            fast = fast.next.next;
        }

        // if loop does not exist
        if(slow != fast)
            return null;

        // if loop exists start slow from head and fast from meeting point
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}