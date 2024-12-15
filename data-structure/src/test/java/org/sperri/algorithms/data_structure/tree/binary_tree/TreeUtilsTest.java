package org.sperri.algorithms.data_structure.tree.binary_tree;

import org.junit.jupiter.api.Test;
import org.sperri.algorithms.data_structure.tree.binary_tree.example.TreeNode;

import java.util.LinkedList;

/**
 * @author Jie Zhao
 * @date 2024/11/30 11:25
 */
public class TreeUtilsTest {

    /**
     * 使用层次遍历
     *
     * @param root
     */
    private void printTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode curr = root; // 当前节点
        while (curr != null || !queue.isEmpty()) {
            if (curr != null) {
                System.out.println(curr.val);
                queue.addLast(curr.left);
                queue.addLast(curr.right);
            } else {
                System.out.println("null");
            }
            curr = queue.removeFirst();
        }
    }

    @Test
    public void testBuildBinaryTreeForLeetcode() {
//        Integer[] integers = {1, 2, 2, 3, 4, 4, 3};
        Integer[] integers = {1,2,2,null,3,null,3};
        TreeNode root = TreeUtils.buildBinaryTreeForLeetcode(integers);
        printTreeNode(root);
    }
}
