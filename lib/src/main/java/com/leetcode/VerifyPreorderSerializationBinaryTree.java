package com.leetcode;

import java.util.Stack;

/**
 * Created by hydra on 2016/11/17.
 */

public class VerifyPreorderSerializationBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] strings  = preorder.split(",");

        Stack<String> stack = new Stack<>();

        for(String s : strings) {
            stack.add(s);
            while (popStackAddSharp(stack)) {
            }
        }
        return stack.size() == 1 && stack.get(0).equals("#") ;
    }

    private boolean popStackAddSharp(Stack<String> stack) {
        if(stack.size() > 2) {
            if(stack.get(stack.size()-1).equals("#") && stack.get(stack.size()-2).equals("#") && !stack.get(stack.size()-3).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
                return true;
            }
        }
        return false;
    }
}
