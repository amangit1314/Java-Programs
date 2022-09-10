package stack_and_queue;
import java.util.*;
import java.util.Stack;
import java.lang.*;

// Problem Title => Next Smaller Element
public class P38 {
    
    // prints element and NSE pair for all elements of arr[] of size n
    public static void printNSE(int[] arr, int n){
        Stack<Integer> s = new Stack<>();

        // push the first element to stack
        s.push(arr[0]);

        // iterate for rest of the elements
        for(int i = 1; i < n; i++){
            if(s.empty()){
                s.push(arr[i]);
                continue;
            }

            // if stack is not empty,
            // then pop an element from stack.
            // If the popped element is greater than next, then
            // (a) print the pair,
            // (b) keep popping while elements are greater and stack is not empty.
            while(!s.empty() && s.peek() > arr[i]){
                System.out.println(s.peek() + " --> " + arr[i]);
                s.pop();
            }

            // push next to stack so that we can find next smaller for it
            s.push(arr[i]);
        }

        // After iterating over the loop,
        // the remaining elements in stack do not have the next smaller element,
        // so print -1 for them
        while(!s.empty()){
            System.out.println(s.peek() + " --> " +  "-1");
            s.pop();
        }
    }

    // Driver function
    public static void main(String[] args) {
        // Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Taking Size of the arrays.array as input from user
        int n = sc.nextInt();

        // Taking the elements of arrays.array as input from user
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Printing the Next Smaller Element by calling printNSE method
        printNSE(arr, n);
    }
}