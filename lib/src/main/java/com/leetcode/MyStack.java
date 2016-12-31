package com.leetcode;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by hydra on 2016/12/31.
 */

public class MyStack {

    Queue<Integer> queue = new ArrayDeque<>();
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    private Integer lastElement() {
        return (Integer) queue.toArray()[queue.size()];
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove(lastElement());
    }

    // Get the top element.
    public int top() {
        return lastElement();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}