package main.java.leetCode;

import java.util.Stack;

/**
 * Created by qiuqian on 1/6/19.
 */
public class MinStack {
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
            return;
        }
        int min = stack.peek();
        stack.push(x);
        stack.push(x <= min ? x : min);
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        int min = stack.pop();
        int val = stack.peek();
        stack.push(min);
        return val;
    }

    public int getMin() {
        return stack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.getMin();  //  Returns -3.
        stack.pop();
        stack.top();      // Returns 0.
        stack.getMin();   // Returns -2.
    }
}
