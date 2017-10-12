package ctci;

import java.util.NoSuchElementException;

public class Stack<T> {
    private int size = 0;

    public int size() {
        return this.size;
    }

    private static class StackNode<T>{
        private T data;
        private StackNode next;

        public StackNode(T item){
            this.data = item;
        }
    }

    private StackNode<T> top;


    public T pop(){
        if(top == null) throw new NoSuchElementException();
        T data = top.data;
        top = top.next;
        this.size--;
        return data;
    }

    public void push(T item){
        StackNode<T> node = new StackNode<>(item);
        node.next = top;
        top = node;
        this.size++;
    }

    public T peek(){
        if(top == null) throw new NoSuchElementException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
