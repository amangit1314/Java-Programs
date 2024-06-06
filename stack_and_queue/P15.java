package stack_and_queue;
import java.util.Stack;
import java.util.*;

// Program Title => Sort a stack using Recursion
public class P15 {

    // Recursive Method to insert an item x in sorted way
    static void sortedInsert(Stack<Integer> s, int x){

        // Base case: Either stack is empty or newly inserted item is greater than top (more than all existing)
        if(s.isEmpty() || x > s.peek()){
            s.push(x);
            return;
        }

        // if top is greater, remove the top item and recur
        int temp = s.pop();
        sortedInsert(s, x);

        // put back the top item removed earlier
        s.push(temp);
    }

    // function to sort the stack
    static void sortStack(Stack<Integer> s){

        // checking if stack is not empty
        if(!s.isEmpty()){

            // Remove the top item
            int x = s.pop();

            // Sort remainig stack
            sortStack(s);

            // Push the top item back in sorted stack
            sortedInsert(s,x);
        }
    }

    // function to sort the arrays.array
    static void printStack(Stack<Integer> s){

        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while(lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.println(lt.previous() + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        Stack<Integer> s = new Stack<>();
        for(int i= 0; i < array.length; i++){
            System.out.println("Enter your number: ");
            int value = sc.nextInt();
            s.push(value);
        }

        sc.close();

        while (!(s.isEmpty()))
            System.out.println(s.pop());

        System.out.println("Stack elements before sorting: ");
        printStack(s);

        sortStack(s);

        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);
    }
}