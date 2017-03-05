package com.leetcode.TwoHundred;

/**
 * Created by hydra on 2017/3/5.
 */

public class ConvertSortedArraytoBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;

        return buildTree(nums, 0, nums.length-1);
    }

    public TreeNode buildTree(int[] nums, int start , int end) {
        if(start > end) return null;
        if(start - end == 0) return new TreeNode(nums[start]);


        int index = (int)((end - start)/2)+start;
        TreeNode root = new TreeNode(nums[index]);

        root.left = buildTree(nums, start , index -1);
        root.right = buildTree(nums, index+1 , end);

        return root;
    }
}
