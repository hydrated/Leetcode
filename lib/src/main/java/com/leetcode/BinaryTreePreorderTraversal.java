package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hydra on 2017/1/7.
 */

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> returnSet = new ArrayList<>();

        if (root != null) {
            List<Integer> leftTree = preorderTraversal(root.left);
            List<Integer> rightTree = preorderTraversal(root.right);

            returnSet.add(root.val);
            returnSet.addAll(leftTree);
            returnSet.addAll(rightTree);
        }

        return returnSet;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> returnList = new ArrayList<>();
        if(root != null) stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            returnList.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }

        return returnList;

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
