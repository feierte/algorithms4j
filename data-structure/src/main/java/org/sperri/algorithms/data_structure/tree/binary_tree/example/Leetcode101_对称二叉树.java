package org.sperri.algorithms.data_structure.tree.binary_tree.example;

import org.sperri.algorithms.data_structure.tree.binary_tree.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述：给你一个二叉树的根节点 root，检查它是否轴对称。
 *
 * @author Jie Zhao
 * @date 2024/11/10 12:58
 */
public class Leetcode101_对称二叉树 {

    public static void main(String[] args) {
        Leetcode101_对称二叉树 solution = new Leetcode101_对称二叉树();
        Integer[] integers = {1, 2, 2, 3, 4, 4, 3};
//        Integer[] integers = {1,2,2,null,3,null,3};
//        Integer[] integers = {1,2,2,2,null,2};
        TreeNode root = TreeUtils.buildBinaryTreeForLeetcode(integers);
        System.out.println(solution.isSymmetric2(root));
    }

    /**
     * 第一种解法：从根节点同时向两边遍历，边遍历边比较
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return false;
        }

        return isSymmetricInternal(root.left, root.right);
    }

    public boolean isSymmetricInternal(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        // 到这里说明 left 和 right 不能同时为 null，即两个有一个是 null，一个不是 null
        // left == null 相当于 left == null && right != null
        // right == null 相当于 left != null && right == null
        if (left == null || right == null) {
            return false;
        }

        // left 和 right 都不为 null
        if (left.val != right.val) {
            return false;
        }

        return isSymmetricInternal(left.left, right.right) &&
                isSymmetricInternal(left.right, right.left);
    }

    /**
     * 第一种解法：找到中序遍历序列，查看序列是否对称
     * 注意：中序遍历时一定要像完全二叉树那样遍历，不能省略空节点
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        // 前序 1 2 3 4 2 4 3
        // 中序 3 2 4 1 4 2 3
        // 后序 3 4 2 4 3 2 1

        // 中序遍历二叉树，得到一个中序遍历的序列
        // 注意这里的遍历一定要是满二叉树的遍历
        List<TreeNode> treeNodes = inOrder(root);
        if (treeNodes == null || treeNodes.size() % 2 == 0) {
            return false;
        }

        int size = treeNodes.size();
        int middle = size / 2;
        for (int i = 0; i < treeNodes.size(); i++) {
            // 遍历元素过半后，没有不相等的元素，说明是对称的，结束遍历即可
            // 也是一个小的优化，减少了时间复杂度
            if (i >= middle) {
                break;
            }

            // 比较树中的对称两个元素是否相等
            if (treeNodes.get(i).val != treeNodes.get(size - i - 1).val) {
                return false;
            }
        }
        return true;
    }

    public List<TreeNode> inOrder(TreeNode root) {
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                nodes.add(pop);
                curr = pop.right;
            }
        }
        return nodes;
    }
}
