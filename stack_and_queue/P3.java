package stack_and_queue;

//Implement two stack in an arrays.array

public class P3 {

	int size, top1, top2;
	int[] a;

	P3(int n) {
		a = new int[n];
		size = n;
		top1 = -1;
		top2 = size;
	}

	void push1(int x) {
		if (top1 < top2 - 1) {
			top1++;
			a[top1] = x;
		} else {
			System.out.println("Stack Overflow");
			System.exit(1);
		}
	}

	void push2(int x) {
		if (top1 < top2 - 1) {
			top2--;
			a[top2] = x;
		} else {
			System.out.println("Stack Overflow");
			System.exit(1);
		}
	}

	int pop1() {
		if (top1 >= 0) {
			int x = a[top1];
			top1--;
			return x;
		} else {
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return 0;
	}

	int pop2() {
		if (top1 < size) {
			int x = a[top2];
			top2++;
			return x;
		} else {
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return 0;
	}

	public static void main(String[] args) {

		P3 ts = new P3(5);
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);

		System.out.println("Popped element from" + " stack 1 is " + ts.pop1());
		ts.push2(40);
		System.out.println("Popped element from" + " stack 2 is " + ts.pop2());
	}

}
