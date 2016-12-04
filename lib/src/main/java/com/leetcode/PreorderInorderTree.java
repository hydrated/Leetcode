package com.leetcode;

import java.util.HashMap;

/**
 * Created by hydra on 2016/12/4.
 */

public class PreorderInorderTree {
    // node order , index of inorder
    HashMap<Integer, Integer> inorderMap ;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        generateMap(inorder);


        return buildNode(preorder, 0, preorder.length, inorder , 0, inorder.length);

    }

    public void generateMap(int[] inorder) {
        inorderMap = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; ++i) {
            inorderMap.put(inorder[i], i);
        }
    }


    private TreeNode buildNode(int[] preorder , int preStart, int preEnd , int[] inorder , int inStart, int inEnd) {
        if(preEnd < preStart) return null;
        if(preStart >= preorder.length) return null;
        if(preEnd == preStart) return new TreeNode(preorder[preStart]);

        int index = inorderMap.get(preorder[preStart]);
        TreeNode node = new TreeNode(preorder[preStart]) ;



        node.left = buildNode(preorder, preStart+1 , preStart + index - inStart, inorder , inStart , index -1);
        node.right = buildNode(preorder, preEnd + index - inEnd +1 , preEnd, inorder , index+1, inEnd );

        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
