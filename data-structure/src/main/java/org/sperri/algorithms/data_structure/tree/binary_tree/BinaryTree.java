package org.sperri.algorithms.data_structure.tree.binary_tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zj
 * @date 2020/7/12 11:22
 */
public class BinaryTree<T>  {


    private Node<T> root;

    /**
     * 二叉树前序遍历
     * @return
     */
    public List<T> preOrderTraverse() {
        Node<T> root = this.root;
        if (root == null) {
            return null;
        }
        List<T> nodes = new ArrayList<>();
        doPreOderTraverseRecursively(root, nodes);
        return nodes;
    }

    /**
     * 递归实现前序遍历
     * @param node
     * @param traverse
     */
    private void doPreOderTraverseRecursively(Node<T> node, List<T> traverse) {
        if (node == null) {
            return;
        }
        traverse.add(node.data);
        doPreOderTraverseRecursively(node.getLeft(), traverse);
        doPreOderTraverseRecursively(node.getRight(), traverse);
    }

    @Data
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
    }
}
