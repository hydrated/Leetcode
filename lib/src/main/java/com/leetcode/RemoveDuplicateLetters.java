package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by hydra on 2016/12/31.
 */

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {

        char[] chars = s.toCharArray();

        int[] counters = new int[26];

        Stack<Character> stack = new Stack<>();

        for(char c : chars) {
            counters[c-97] += 1;
        }

        for(Character c : chars) {
            if(stack.contains(c)) {
            } else {
                while(stack.size() > 0 && stack.peek() > c && counters[stack.peek()-97] > 0) {
                    stack.pop();
                }
                stack.push(c);
            }
            counters[c-97] -= 1;
        }

        String str = "";

        for(Character c : stack) {
            str += c.toString();
        }

        return str;
    }
}
