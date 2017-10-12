package ctci;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    ArrayList<SetStack<Integer>> stacks = new ArrayList<>();
    int capacity;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
    }

    public void push(int value){
        SetStack last = getLastStack();
        if(last != null && !last.isFull()){
            last.push(value);
        } else {
            last = new SetStack();
            last.push(value);
            stacks.add(last);
        }
    }

    public int pop(){
        SetStack<Integer> last = getLastStack();
        if(last == null) throw new EmptyStackException();
        int value = (int) last.pop();
        if(last.size == 0) stacks.remove(stacks.size() - 1);
        return value;
    }

    private SetStack getLastStack() {
        if(stacks.isEmpty()) return null;
        return stacks.get(stacks.size() - 1);
    }
}

class SetStack<I> extends Stack{

    private int capacity;
    public int size;

    public boolean isFull() {
        return size == capacity;
    }
}