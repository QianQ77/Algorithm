package main.java.leetCode;

import java.util.*;

/**
 * Created by qiuqian on 8/19/18.
 */
public class MaxSlidingWindow {
    //nlogk
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer> (k, Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++){
            if (maxHeap.size() < k) {
                maxHeap.add(nums[i]);
            } else {
                maxHeap.remove(nums[i - k]);
                maxHeap.add(nums[i]);
            }
            if(i >= k - 1) {
                result[i - k + 1] = maxHeap.peek();
            }

        }
        return result;
    }

    int maxInPushStack = Integer.MIN_VALUE;

    //n
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];

        Stack<Integer> pushStack = new Stack<>();

        Stack<Integer> maxStack = new Stack<>();
        int i = 0;
        while(i >= 0 && i < k) {
            pushToStack(pushStack, maxStack, nums[i]);
            i++;
        }
        result[0] = getMax(pushStack, maxStack);
        for(i = k; i < nums.length; i++) {
            //should not be if(nums[i - 1] == getMax(pushStack, maxStack))
            if(nums[i - k] == getMax(pushStack, maxStack)) {
                maxStack.pop();
                while(!maxStack.isEmpty() && maxStack.peek() < maxInPushStack) {
                    maxStack.pop();
                }

            }
            pushToStack(pushStack, maxStack, nums[i]);
            result[i - k + 1] = getMax(pushStack, maxStack);
        }
        return result;
    }

    public void pushToStack(Stack<Integer> pushStack, Stack<Integer> maxStack, int num) {
        while(!pushStack.isEmpty() && pushStack.peek() < num) {
            pushStack.pop();
        }
        while(!maxStack.isEmpty() && maxStack.peek() < num) {
            maxStack.pop();
        }
        pushStack.push(num);
        maxInPushStack = Math.max(maxInPushStack, num);
    }

    public int getMax(Stack<Integer> pushStack, Stack<Integer> maxStack) {
        if(maxStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                maxStack.push(pushStack.pop());
            }
            maxInPushStack = Integer.MIN_VALUE;
        }
        return maxStack.peek();
    }

    //Best solution. O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i >= k && nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            enqueue(deque, nums[i]);
            if(i >= k - 1) {
                result[i - k + 1] = deque.peekFirst();
            }
        }
        return result;
    }

    public void enqueue(Deque<Integer> deque, int num) {
        while(deque.size() != 0 && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offerLast(num);
    }


}
