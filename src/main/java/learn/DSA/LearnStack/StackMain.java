package learn.DSA.LearnStack;

public class StackMain {
    public static void main(String[] args) {
        // StackImpl<Integer> stack = new StackImpl<>(5);
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // stack.push(4);
        // System.out.println(stack.top());
        // for(int i = 0; i < stack.size(); i++){
        //     System.out.print(stack.peek() + " ");
        //     stack.pop();
        // }

        StackImplByLinkedList<Integer> stackByLinkedList = new StackImplByLinkedList<>();
        stackByLinkedList.push(1);
        stackByLinkedList.push(2);
        stackByLinkedList.push(3);
        stackByLinkedList.push(4);
        stackByLinkedList.printStack(); 
        System.out.println();
        stackByLinkedList.pop();
        stackByLinkedList.printStack();
        System.out.println();
        stackByLinkedList.push(5);
        stackByLinkedList.printStack();
    }
}
