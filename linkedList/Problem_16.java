 
 // Problem Title - Split a circular linked list into two halves

 public class Problem_16 {
     
        node head = null;
        // node a, b;
        static class node {
            int val;
            node next;
    
            public node(int val) {
                this.val = val;
            }
        }
    
        void splitList() {
            node slow = head;
            node fast = head;
    
            if(head == null)
                return;
            
            while(fast.next != head && fast.next.next != head) {
                slow = slow.next;
                fast = fast.next.next;
            }
    
            if(fast.next.next == head)
                fast = fast.next;
    
            node head1 = head;
            node head2 = slow.next;
            fast.next = slow.next;
            slow.next = head;
        }
    
        // Utility function to print the linked linkedList.list
        void printList(node headref) {
            while (headref != null) {
                System.out.print(headref.val + " ");
                headref = headref.next;
            }
        }
    
        public static void main(String[] args) {
            Problem_16 li = new Problem_16();
            li.head = new node(1);
            li.head.next = new node(2);
            li.head.next.next = new node(3);
            li.head.next.next.next = new node(4);
            li.head.next.next.next.next = new node(5);
            li.head.next.next.next.next.next = li.head;
            li.splitList();
            li.printList(li.head);
        }
 } 