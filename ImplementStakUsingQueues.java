package main.java.leetCode;

import java.util.LinkedList;

/**
 * Created by qiuqian on 8/6/17.
 */
public class ImplementStakUsingQueues {
    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;
    /** Initialize your data structure here. */
    public ImplementStakUsingQueues() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty()){
            queue2.offer(x);
        }else{
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        LinkedList<Integer> from;
        LinkedList<Integer> to;
        if(queue1.isEmpty()){
            from = queue2;
            to = queue1;
        }else{
            from = queue1;
            to = queue2;
        }
        while(from.size() > 1){
            to.offer(from.pop());
        }
        return from.pop();
    }

    /** Get the top element. */
    public int top() {
        LinkedList<Integer> from;
        LinkedList<Integer> to;
        if(queue1.isEmpty()){
            from = queue2;
            to = queue1;
        }else{
            from = queue1;
            to = queue2;
        }
        int num = -1;
        while(from.size() > 0){
            if(from.size() == 1){
                num = from.peek();
            }

            to.offer(from.pop());

        }
        return num;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return(queue1.isEmpty() && queue2.isEmpty());
    }

    public static void main(String[] args){
        ImplementStakUsingQueues stack = new ImplementStakUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println("pop:" + stack.pop());
        System.out.println("top:" + stack.top());
    }
}
