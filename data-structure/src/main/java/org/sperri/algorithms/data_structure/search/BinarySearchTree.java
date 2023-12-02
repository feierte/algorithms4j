package org.sperri.algorithms.data_structure.search;

import org.sperri.algorithms.data_structure.tree.AbstractBinaryTree;
import org.sperri.algorithms.data_structure.tree.BinaryTree;
import org.sperri.algorithms.data_structure.tree.SortedTree;

import java.util.Comparator;

/**
 * @author zj
 * @date 2020/7/12 18:10
 */
public class BinarySearchTree<K, V> extends AbstractBinaryTree<K, V>
        implements SortedTree<K, V> {

    @Override
    public boolean add(BiNode<K, V> node) {
        return false;
    }

    @Override
    public Comparator<? super K> comparator() {
        return null;
    }

    @Override
    public SortedTree<K, V> subTree(K fromKey, K toKey) {
        return null;
    }
}
