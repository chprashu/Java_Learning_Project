package learn.DSA.LearnStack;

//Stack Implementation using Array
public class StackImpl<T> {
    private int initialSize = 10;
    private T[] stack;
    private int index = 0;

    public StackImpl(Integer initialSize) {
        this.initialSize = initialSize;
        this.stack = (T[]) new Object[initialSize];
    }

    public T top(){
        if(isEmpty()) return null;
        return stack[index - 1];
    }

    public T peek(){
        return top();
    }

    public boolean isEmpty(){
        if(index == 0) return true;
        return false;
    }

    private void resizeStack(){
        this.initialSize = (int) (initialSize / 2) + initialSize;
        T[] newStack = (T[]) new Object[initialSize];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public Boolean push(T data){
        if(stack[stack.length - 1] != null) {
            resizeStack();
        }
        stack[index++] = data;
        return true;
    }

    public Boolean pop(){
        if(isEmpty()) return false;
        stack[--index] = null;
        return true;
    }

    public int size(){
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(T i : stack){
            if(i != null) sb.append(i).append(" ");
        }
        return sb.toString();
    }


}
