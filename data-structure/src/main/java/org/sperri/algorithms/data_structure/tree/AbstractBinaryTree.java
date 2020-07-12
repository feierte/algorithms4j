package org.sperri.algorithms.data_structure.tree;

import java.util.Objects;

/**
 * @author zj
 * @date 2020/7/12 18:04
 */
public abstract class AbstractBinaryTree<K, V> extends AbstractTree<K, V> {


    /**
     * the root node of this binary tree.
     */
    private BiNode<K, V> root;

    /**
     * the numbers of node contained in this binary tree.
     */
    private transient int size;


    protected abstract boolean add(BiNode<K, V> node);

    /**
     * 向当前节点中插入左孩子节点
     * @param currentNode
     * @param key
     * @param value
     * @return
     */
    public void addLeftChild(BiNode<K, V> currentNode, K key, V value) {
        currentNode.setLeftNode(new BiNode<>(key, value));
    }

    /**
     * 向当前节点插入右孩子节点
     * @param currentNode
     * @param key
     * @param value
     * @return
     */
    public void addRightChild(BiNode<K, V> currentNode, K key, V value) {
        currentNode.setRightNode(new BiNode<>(key, value));
    }

    public Object get(Object key) {
        // TODO
        return null;
    }

    public int size() {
        return size;
    }

    protected static class BiNode<K, V> implements Tree.Node<K, V> {

        private final K key;
        private V value;

        //private Node<K, V> parent;
        private BiNode<K, V> leftNode;
        private BiNode<K, V> rightNode;

        // 此节点的前一个结点，用于层次遍历，如果不需要层次遍历，则可以不需要这个field
        private BiNode<K, V> prevNode;

        public BiNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BiNode<K, V> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(BiNode<K, V> leftNode) {
            this.leftNode = leftNode;
        }

        public BiNode<K, V> getRightNode() {
            return rightNode;
        }

        public void setRightNode(BiNode<K, V> rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public BiNode<K, V> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(BiNode<K, V> prevNode) {
            this.prevNode = prevNode;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = getValue();
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (!(obj instanceof BiNode)) {
                return false;
            }

            BiNode biNode = (BiNode) obj;
            return Objects.equals(this.key, biNode.getKey()) &&
                    Objects.equals(this.value, biNode.getValue());

        }


        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
