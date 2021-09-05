package ssp.ssp;

// Problem TItle => Implement stack from scratch
public class Problem_1 {
    public static void main(String[] args) {

    }
}

/**
 * Stack
 */
class Stack {
    static final int MAX = 100;
    int top;
    int[] a = new int[MAX];

    Stack() {
        top = -1;
    }

    boolean isEmpty() {
        return (top < 0);
    }

    boolean pop(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    int push() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }

    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = a[top];
            return x;
        }
    }

    void print() {
        for (int i = top; i > -1; i--) {
            System.out.print(" " + a[i]);
        }
    }
}
