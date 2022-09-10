package stack_and_queue.practice;

// Problem Title => Implement Stack from Scratch

public class Stacks {

    static class MyStack{
        static final int MAX = 1000;
        int top;
        int[] a = new int[MAX];

        boolean isEmpty(){
            return (top <= 0);
        }

        MyStack() {
            top = -1;
        }

        boolean push(int x){
            if(top >= MAX-1){
                System.out.println("Stack Overflow");
                return false;
            }
            else {
                a[++top] = x;
                System.out.println(x + " pushed into stack");
                return true;
            }
        }

        int pop(){
            if(top < 0){
                System.out.println("Stack Underflow");
                return 0;
            }
            else
                return a[top--];
        }

        int peek(){
            if(top < 0){
                System.out.println("Stack Underflow");
                return 0;
            }
            else
                return a[top];
        }
    }

    public static void main(String[] args) {
        // created the object of Stack class
        MyStack s = new MyStack();

        // pushing element's to stack
        s.push(10);
        s.push(20);
        s.push(30);

        // printing the elements of stack by popping them
        System.out.println(s.pop() + " Popped from stack");

        // peek from stack to see the top element
        s.peek();

        // checking if stack is empty or not
        System.out.println(s.isEmpty());
    }
}