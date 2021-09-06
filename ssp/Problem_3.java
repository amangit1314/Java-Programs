package ssp;

class twoStacks {
    int[] arr;
    int size;
    int top1, top2;

    // Constructor
    twoStacks(int n) {
        size = n;
        arr = new int[n];
        top1 = n / 2;
        top2 = n / 2;
    }

    // Push method for stack1
    void push1(int x) {
        if (top1 > 0) {
            top1--;
            arr[top1] = x;
        } else {
            System.out.print("Stack overflow" + "By element :" + x + "\n");
            return;
        }
    }

    // Push method for stack2
    void push2(int x) {
        if (top2 < size - 1) {
            top2++;
            arr[top2] = x;
        } else {
            System.out.print("Stack Overflow" + " By element :" + x + "\n");
            return;
        }
    }

    // Pop method for stack1
    int pop1() {
        if (top1 <= size / 2) {
            int x = arr[top1];
            top1++;
            return x;
        } else {
            System.out.print("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    // Pop method for stack 2
    int pop2() {
        if (top2 >= size / 2 + 1) {
            int x = arr[top2];
            top2--;
            return x;
        } else {
            System.out.print("Stack Underflow");
            System.exit(1);
        }
        return 1;
    }
}

public class Problem_3 {
    public static void main(String[] args) {
        twoStacks ts = new twoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.print("Popped element from stack1 is " + " : " + ts.pop1() + "\n");
        ts.push2(40);
        System.out.print("Popped element from stack2 is " + ": " + ts.pop2() + "\n");
    }
}
