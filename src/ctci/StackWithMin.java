package ctci;

import java.util.EmptyStackException;

public class StackWithMin extends Stack<NodeWithMin> {

    public void push(int value){
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE;
        } else {
            return this.peek().min;
        }
    }
}

class NodeWithMin{
    int min;
    int value;

    public NodeWithMin(int value, int min){
        this.min = min;
        this.value = value;
    }
}
