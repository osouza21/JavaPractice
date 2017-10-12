package ctci;

public class StacksAndQueues {
    public static Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<Integer>();
        while(!stack.isEmpty()){
            int x = stack.pop();
            while(!temp.isEmpty() && temp.peek() > x){
                stack.push(temp.pop());
            }
            temp.push(x);
        }

        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return stack;
    }
}
