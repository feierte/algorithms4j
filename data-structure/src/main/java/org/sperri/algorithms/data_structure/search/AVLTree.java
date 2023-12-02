package org.sperri.algorithms.data_structure.search;

import lombok.Data;

/**
 * @author Jie Zhao
 * @date 2023/10/13 10:52
 */
@Data
public class AVLTree<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private int height; // 树的高度

    public AVLTree() {

    }

    public int height() {
        return height;
    }

    public void put(K key, V value) {

    }

    @Data
    static class Node<K, V> {

        private K key; // 用来比较大小
        private V value; // 用来存储数据
        private Node<K, V> left; // 左孩子
        private Node<K, V> right; // 右孩子
        private Node<K, V> parent; // 父节点

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> left, Node<K, V> right, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        /**
         * 当前节点的高度（包含自身）
         * @return
         */
        public int height() {
            int leftHeight =
                    this.left == null ? 0 : this.left.height();
            int rightHeight =
                    this.right == null ? 0 : this.right.height();
            return Math.max(leftHeight, rightHeight) + 1;
        }

        /**
         * 判断当前节点是否处于平衡状态
         * @return
         */
        public boolean isBalanced() {
            // 0,1,-1 为平衡
            // >1, <-1 为不平衡
            return Math.abs(balanceFactor()) < 2;
        }

        /**
         * 当前节点的平衡因子 = 左子树高度 - 右子树高度
         * @return
         */
        public int balanceFactor() {
            return 0;
        }

        public RotateMode rotateMode() {
            return null;
        }

        /**
         * 左旋转
         */
        public void leftRotate() {

        }

        /**
         * 右旋转
         */
        public void rightRotate() {

        }
    }
}
