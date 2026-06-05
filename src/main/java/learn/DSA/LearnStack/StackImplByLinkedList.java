package learn.DSA.LearnStack;

//Stack Implementation using Linked List
public class StackImplByLinkedList<T> {

    private Node<T> top;

    public StackImplByLinkedList(){}

    public void push(T data){
        Node<T> newNode = new Node<>(data);
        if(top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }

    public void printStack(){
        Node<T> temp = top;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void pop(){
        if(!isEmpty()) top = top.next;
    }

    public boolean isEmpty(){
        if(top == null) return true;
        return false;
    }

    
}


class Node<T>{
    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
    }
}
