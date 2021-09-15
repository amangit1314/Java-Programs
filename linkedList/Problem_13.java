package linkedList;
// Problem Title => Merge Sort For Linked lists.[Very Important]
public class Problem_13 {
    node head = null;

    static class node{
        int val;
        node next;
        public node(int val){
            this.val = val;
        }
    }

    node sortedMerge(node a, node b){
        node result = null;
        if(a == null)
            return b;
        if(b == null)
            return b;
        if(a.val <= b.val){
            result = a;
            result.next = sortedMerge(a, b.next);
        }
    }
    public static void main(String[] args) {

    }
}