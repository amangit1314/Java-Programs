package stack_and_queue.practice;

public class StackByArray {

    static final int MAX = 1000;
    static int top;
    static int[] a = new int[MAX];

    StackByArray() {
        top = -1;
    }

    public static boolean push(int element) {
        if(top >= (MAX - 1)){
            System.out.println("Stack overflow");
            return false;
        }
        else{
            a[++top] = element;
            System.out.println(element + "is pushed into stack");
            return true;
        }
    }

    public static int pop() {
        if(top < 0)
            return 0;
        else
            return a[top--];
    }

    public static boolean isEmpty() {
        return (top < 0);
    }

    public static int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
            return a[top];
    }

    public static void print() {
        for(int i = top; i > -1; i--)
            System.out.print(" " + a[i]);
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        System.out.println(pop() + " Popped from stack");
        System.out.println("Top element is :" + peek());
        System.out.print("Elements present in stack :");
        print();
    }
}