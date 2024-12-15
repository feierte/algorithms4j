package org.sperri.algorithms.data_structure.tree.binary_tree;

import org.apache.commons.lang3.ArrayUtils;
import org.sperri.algorithms.data_structure.tree.binary_tree.example.TreeNode;

import java.util.LinkedList;

/**
 * @author Jie Zhao
 * @date 2024/11/30 10:53
 */
public abstract class TreeUtils {

    /**
     * 使用数组构造二叉树
     *
     * @param array
     * @return
     */
    public static TreeNode buildBinaryTreeForLeetcode(Integer[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return null;
        }

        // n 表示数组的索引位置
        // n 是头结点，则相应的左子树是 2n+1，相应的右子树是 2(n+1)
        TreeNode root = null; // 整个二叉树的头节点
        TreeNode curr = null; // 当前节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            // 构造整个二叉树的头节点
            if (i == 0) {
                root = new TreeNode(array[i]);
                curr = root;
            }

            // 当前节点是 null，没有左右子树，跳过即可
            if (curr == null) {
                continue;
            }

            // 构造当前节点的左子树
            // 超过数组索引最大长度 || 左子树本身为 null
            if (2 * i + 1 >= array.length || array[2 * i + 1] == null) {
                curr.left = null;
            } else {
                curr.left = new TreeNode(array[2 * i + 1]);
            }
            queue.addLast(curr.left);
            // 构造当前节点的右子树
            if ((2 * (i + 1)) >= array.length || array[2 * (i + 1)] == null) {
                curr.right = null;
            } else {
                curr.right = new TreeNode(array[2 * (i + 1)]);
            }
            queue.addLast(curr.right);

            // 如何接着构造下一个节点，即 curr 如何移动？使用队列
            curr = queue.removeFirst();
        }
        return root;
    }
}
