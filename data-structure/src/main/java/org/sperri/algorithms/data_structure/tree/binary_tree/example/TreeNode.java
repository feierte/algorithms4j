package org.sperri.algorithms.data_structure.tree.binary_tree.example;

/**
 * Definition for a binary tree node.
 *
 * @author Jie Zhao
 * @date 2024/11/30 10:54
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}