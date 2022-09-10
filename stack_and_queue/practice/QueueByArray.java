package stack_and_queue.practice;

public class QueueByArray {
    private static int front;
    private static int rear;
    private static int capacity;
    private static int[] queue;

    QueueByArray(int cap){
        front = rear = 0;
        capacity = cap;
        queue = new int[capacity];
    }

    public static void enqueue(int data) {
        if(capacity == rear)
            return;

        else {
            queue[rear] = data;
            rear++;
        }
    }

    public static void dequeue() {
        if(front == rear)
            return;

        else {
            for(int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }

            if(rear < capacity)
                queue[rear] = 0;

            rear--;
        }
        return;
    }

    public static void front() {
        if(front == rear)
            return;

        System.out.printf("\nFront Element is: %d", queue[front]);
        return;
    }

    public static void display() {
        int i;
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++)
            System.out.printf(" %d <-- ", queue[i]);

        return;
    }

    public static void main(String[] args) {
        // print Queue elements
        display();

        // inserting elements in the queue
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);

        // print Queue elements
        display();

        // insert element in the queue
        enqueue(60);

        // print Queue elements
        display();

        dequeue();
        dequeue();
        System.out.print("\n\nafter two node deletion\n\n");

        // print Queue elements
        display();

        // print front of the queue
        front();
    }
}
