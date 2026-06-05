package learn.DSA.LearnQueue;

//Queue Implementation using Linked List
public class QueueImplLinkedList<T> {
    public QueueImplLinkedList(){};

    private Node<T> front;
    private Node<T> rear;

    public void enqueue(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            this.front = newNode;
        }else{
            this.rear.next = newNode;
        }
        this.rear = newNode;
    }

    public Boolean isEmpty(){
        return front == null;
    }

    public T peek(){
        return this.front.data;
    }

    public void printQueue(){
        Node<T> temp = front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        this.front = this.front.next;
    }
}

class Node<T>{
    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
    }
}
