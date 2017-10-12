package ctci;

public class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue(){
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value){
        stackNewest.push(value);
    }

    private void shiftStack(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek(){
        shiftStack();
        return stackOldest.peek();
    }

    public T remove(){
        shiftStack();
        return stackOldest.pop();
    }
}
