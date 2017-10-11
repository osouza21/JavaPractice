package ctci;

import java.util.EmptyStackException;

/**
 * CTCI 3.1
 * Fixed multi stack holds three stacks in an array
 */
public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    /* push on to stack */
    public void push(int stackNum, int value) throws FullStackException{
        /* Check that we have space for the next element */
        if(isFull(stackNum)){
            throw new FullStackException();
        }

        /* Increment stack pointer and then ypdate top value */
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /* Pop item from top stack */
    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex]; // get value
        values[topIndex] = 0; // Clear
        sizes[stackNum]--; // shrink stack
        return value;
    }

    /* Return top element */
    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);
        return values[topIndex];
    }

    /* Is the stack empty */
    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    /* Is the stack full */
    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    /* Index of the top of the stack */
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity; // starting index of stack
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
