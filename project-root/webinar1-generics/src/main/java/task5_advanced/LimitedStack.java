package task5_advanced;

import java.util.Stack;

public class LimitedStack<T> {
    private int size = 5;
    private final Stack<T> stack;

    public LimitedStack(int size) {
        this.size = size;
        this.stack = new Stack<>();
    }
    public LimitedStack() {
        this.stack = new Stack<>();
    }

    public void push(T element) throws Exception {
        if (stack.size() < size) {
            stack.push(element);
        } else {
            throw new Exception("Stack is full!");
        }
    }

    public T pop() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return stack.pop();
    }

    public T peek() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return stack.peek();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public boolean isFull() {
        return stack.size() == size;
    }

    public int size() {
        return stack.size();
    }

}
