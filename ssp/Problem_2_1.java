package ssp;
// Problem Title => Implement Queue from scr**

import java.util.Scanner;

/* Queue*/
class Queue {
    int front, rear, size;
    int capacity;
    int[] arr;

    // Public constructor
    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        arr = new int[this.capacity];
    }

    boolean isFull(Queue queue) {
        return (queue.size == queue.capacity);
    }

    boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }

    void enqueue(int item) {
        if  (isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.arr[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to queue");
    }
    
    int dequeue() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
        int item = this.arr[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }
    
    int front() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.arr[this.front];
    }
    
    int rear() {
        if(isEmpty(this))
            return Integer.MIN_VALUE;

        return this.arr[this.rear];
    }
}

public class Problem_2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue queue = new Queue(n);
        sc.close();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() + " dequeued from queue\n");

        System.out.println("Front item is " + queue.front());

        System.out.println("Rear item is " + queue.rear());

    }
    
}
