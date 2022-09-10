package trees.segmentTree;
import java.io.*;

/**
 * <------------------------------------------------------------------------------------------------------------------>
 *     Problem Statement :- In each query you are given an interval l, r both inclusive,
 *                          and you have to find the maximum element in this interval.
 *
 *     Given      :- You are given an array(of integers) of length n.
 *     Need To Do :- You are required to answer q queries.
 * </------------------------------------------------------------------------------------------------------------------>
 *
 * <------------------------------------------------------------------------------------------------------------------>
 * To do the above task you have to create a data structure as follows :-
 *
 * Implement the SegmentTree class :-
 * 1. SegmentTree(int arr[])  :-  Initializes the SegmentTree object with an array,
 * 2. int query(int l, int r) :-  return max in interval [l, r].
 *
 * Expected Time Complexity -> Can you do it in O(log(n)) or better Time Complexity.
 * </------------------------------------------------------------------------------------------------------------------>
 */

public class Max_In_An_Interval {
    // segment tree class
    public static class SegmentTree {
        // tree array
        int[] tree;

        // input array
        int[] array;

        // segment tree class constructor to initialize the array
        SegmentTree(int[] arr) {
            array = arr;
            tree = new int[4 * arr.length];
            build(arr, 1, 0, arr.length - 1);
        }

        // a private build function to build the segment tree
        private void build(int[] arr, int node, int start, int end) {
            if(start == end)
                tree[node] = arr[start];

            else {
                int mid = (start + end) / 2;
                int left = node * 2;
                int right = node * 2 + 1;
                build(arr, left, start, mid);
                build(arr, right, mid + 1, end);
                tree[node] = Math.max(tree[left], tree[right]);
            }
        }

        // helper query function for processing range queries
        private int query(int node, int start, int end, int l, int r) {
            if(end < l || r < start)
                return Integer.MIN_VALUE;

            if(start == end)
                return tree[node];

            else if(l <= start && end <= r)
                return tree[node];

            else {
                int mid = (start + end) / 2;
                int left = query(node * 2, start, mid, l, r);
                int right = query(node * 2 + 1, mid + 1, end, l, r);
                return Math.max(left, right);
            }
        }

        // query function
        int query(int l, int r) {
            return query(1, 0, array.length - 1, l, r);
        }
    }

    // main function
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(read.readLine());
        }

        SegmentTree segment = new SegmentTree(arr);
        int q = Integer.parseInt(read.readLine());

        StringBuilder out = new StringBuilder();
        while(q --> 0) {
            String[] imp = read.readLine().split(" ");

            int l = Integer.parseInt(imp[0]);
            int r = Integer.parseInt(imp[1]);

            int ans = segment.query(l, r);
            out.append(ans);
            out.append("\n");
        }
        System.out.println(out);
    }
}