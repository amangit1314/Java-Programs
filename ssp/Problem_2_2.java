package ssp;
// problem Title => Implement queue from scratch using Linked**
 
class QNode {
    int key;
    QNode next;

    public QNode(int key) {
        this.key = key;
        this.next = null;
    }
}


class Queue2 {
    QNode front, rear;

    public Queue2() {
        this.front = this.rear = null;
    }

    void enqueue(int key) {
        QNode temp = new QNode(key);

        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        this.rear.next = temp;
        this.rear = temp;
    }

    void dequeue() {
        if(this.front == null)
            return;
        QNode temp = this.front;
        this.front = temp.next;

        if(this.front == null)
            this.rear = null;
    }
}

public class Problem_2_2 {

    public static void main(String[] args) {
        Queue2 q = new Queue2();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Queue Front : " + q.front.key);
        System.out.println("Queue Rear : " + q.rear.key);  
    }
}
