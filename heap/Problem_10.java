package heap;
import java.util.*;

/*
    <------------------------------------------------------------------------------------------------------------------>
    Given :- K sorted linked lists of different sizes.
             The task is to merge them in such a way that after merging they will be a single sorted linked list.
    <------------------------------------------------------------------------------------------------------------------>
    Example 1:

    Input: K = 4 , value = {{1,2,3},{4 5},{5 6},{7,8}}
    Output: 1 2 3 4 5 5 6 7 8

    Explanation:
        The test case has 4 sorted linked
        list of size 3, 2, 2, 2
        1st    list     1 -> 2-> 3
        2nd    list     4 -> 5
        3rd    list     5 -> 6
        4th    list     7 -> 8

        The merged list will be
        1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8.
    <------------------------------------------------------------------------------------------------------------------>
    Example 2:

    Input: K = 3 , value = {{1,3},{4,5,6},{8}}
    Output: 1 3 4 5 6 8

    Explanation:
        The test case has 3 sorted linked
        list of size 2, 3, 1.
        1st list 1 -> 3
        2nd list 4 -> 5 -> 6
        3rd list 8

        The merged list will be
        1 -> 3 -> 4 -> 5 -> 6 -> 8.
    <------------------------------------------------------------------------------------------------------------------>
    Your Task:
        The task is to complete the function mergeKList() which merges the K given lists into a sorted one.
        The printing is done automatically by the driver code.
    <------------------------------------------------------------------------------------------------------------------>
     Expected Time Complexity: O(nk Log k)
     Expected Auxiliary Space: O(k)
    <------------------------------------------------------------------------------------------------------------------>
     Note: n is the maximum size of all the k link list
    <------------------------------------------------------------------------------------------------------------------>
    Constraints
        1 <= K <= 103
 */

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Problem_10 {
    public static void printList(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int N = sc.nextInt();
            Node[] a = new Node[N];

            for(int i = 0; i < N; i++) {
                int n = sc.nextInt();
                Node head = new Node(sc.nextInt());
                Node tail = head;

                for(int j = 0; j < n-1; j++) {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                a[i] = head;
            }
            Solution g = new Solution();

            Node res = g.mergeKList(a, N);
            if(res != null)
                printList(res);
            System.out.println();
        }
    }
}

class Solution {
    Node mergeKList(Node[] arr, int K) {
        Node res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = merge(res, arr[i]);
        }
        return res;
    }

    Node merge(Node h1, Node h2) {
        //function to sort two sorted LinkedList
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        Node res = null;
        if (h1.data < h2.data) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h1, h2.next);
            return h2;
        }

    }
}