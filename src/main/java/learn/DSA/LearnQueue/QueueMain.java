package learn.DSA.LearnQueue;

public class QueueMain {
    public static void main(String[] args) {
        QueueImplLinkedList<Integer> queue = new QueueImplLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.printQueue();
        System.out.println(queue.peek());
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue(5);
        queue.printQueue();
    }
}
