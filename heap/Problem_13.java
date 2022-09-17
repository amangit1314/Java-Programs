//package heap;
///*
//Given a binary tree. The task is to check whether the given tree follows the max heap property or not.
//Note: Properties of a tree to be a max heap - Completeness and Value of node greater than or equal to its child.
//
//Example 1:
//
//Input:
//      5
//    /  \
//   2    3
//Output: 1
//Explanation: The given tree follows max-heap property since 5,
//is root and it is greater than both its children.
//
//
// */
//
//
//
//public class Problem_13 {
//    public static void main(String[] args) {
//
//    }
//}
//
//class Nodes{
//    int data;
//    Node left,right;
//    Nodes(int d){
//        data=d;
//        left=right=null;
//    }
//}
//
//class Solution {
//    public static int totalCount(Node root) {
//
//        if(root == null) {
//
//            return 0 ;
//
//        }
//
//        int left = totalCount(root.left) ;
//
//        int right = totalCount(root.right) ;
//
//        return (left + right) +1 ;
//
//    }
//
//    public static boolean isCBT(Node root, int index, int totalCount) {
//
//        if(root == null) {
//
//            return true ;
//
//        }
//
//        if(index>= totalCount) {
//
//            return false ;
//
//        }
//
//        else {
//
//            boolean left = isCBT(root.left, 2*index+1, totalCount) ;
//
//            boolean right = isCBT(root.right, 2*index+2, totalCount) ;
//
//            return (left && right) ;
//
//        }
//
//    }
//
//    public static boolean isMaxHeap(Node root) {
//
//        if(root.left == null && root.right == null) {
//
//            return true ;
//
//        }
//
//        if(root.right == null) {
//
//            return root.data > root.left.data ;
//
//        }
//
//        else {
//
//            boolean left = isMaxHeap(root.left) ;
//
//            boolean right = isMaxHeap(root.right) ;
//
//            if(left && right && root.data > root.left.data && root.data > root.right.data) {
//
//                return true ;
//
//            }
//
//        }
//
//        return false ;
//
//    }
//
//    boolean isHeap(Node root) {
//
//        int index =0 ;
//
//        int totalCount = totalCount(root) ;
//
//        if(isCBT(root, index, totalCount) && isMaxHeap(root)){
//
//            return true ;
//
//        }
//
//        else{
//
//            return false ;
//
//        }
//
//    }
//
//}