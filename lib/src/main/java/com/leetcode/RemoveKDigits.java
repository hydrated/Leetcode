package com.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by hydra on 2017/1/7.
 */

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        char[] charNum = num.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < charNum.length ; ++i) {
            if(stack.peek() < Integer.parseInt(num.substring(i,i))) {
                if(stack.size() < k) {
                    stack.push(i);
                } else {

                }

            }
        }

        return null;
    }
}
