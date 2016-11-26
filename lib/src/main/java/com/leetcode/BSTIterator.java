package com.leetcode;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by hydra on 2016/11/26.
 */

public class BSTIterator {

    TreeNode root ;
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        if(root != null) stackAllLeftNode(root);
    }

    private void stackAllLeftNode(TreeNode node) {
        stack.push(node);
        while(node.left != null) {
            stack.push(node.left);
            node = node.left;
        }
    }
    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        if(node.right != null) {
            stackAllLeftNode(node.right);
        }
        return node.val;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
