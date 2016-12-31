package com.leetcode;

import java.util.Stack;

/**
 * Created by hydra on 2016/12/31.
 */

public class MyQueue {

    Stack<Integer> stack = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    private Integer firstElement() {
        return (Integer) stack.toArray()[0];
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.remove(firstElement());
    }

    // Get the front element.
    public int peek() {
        return firstElement();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}