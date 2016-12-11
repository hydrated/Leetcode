package com.leetcode;

/**
 * Created by hydra on 2016/12/11.
 */

public class DeleteNodeinaBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode fakeRoot = new TreeNode(0);
        fakeRoot.right = root;

        findDeleteNode(fakeRoot, root, key);


        return fakeRoot.right;

    }

    private void findDeleteNode(TreeNode parent, TreeNode node, int key) {
        if(node == null) { // not fou d
            return;
        }

        if(node.val == key) {
            replaceNode(parent, node);
        } else if (node.val < key) {
            findDeleteNode(node, node.right, key);
        } else {
            findDeleteNode(node, node.left, key);
        }

    }

    private void replaceNode(TreeNode parent, TreeNode deleteNode) {
        if(deleteNode.right == null) {
            if(deleteNode.val < parent.val) {
                parent.left = deleteNode.left;
            } else {
                parent.right = deleteNode.left;
            }
        } else {
            TreeNode minimumRightLeaf;
            if(deleteNode.right.left != null) {
                minimumRightLeaf = findMinimumNodeByRightLeaf(deleteNode, deleteNode.right);
            } else {
                minimumRightLeaf = deleteNode.right;
            }
            if(deleteNode.val < parent.val) {
                parent.left = minimumRightLeaf;
            } else {
                parent.right = minimumRightLeaf;
            }
            minimumRightLeaf.left = deleteNode.left;
            minimumRightLeaf.right = deleteNode.right;

        }

    }

    // Nonnull
    private TreeNode findMinimumNodeByRightLeaf(TreeNode root, TreeNode node) {
        if(node.left == null) {
            root.left = null;
            return node;
        } else {
            return findMinimumNodeByRightLeaf(node, node.left);
        }

    }


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }
}
