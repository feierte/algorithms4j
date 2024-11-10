package org.sperri.algorithms.data_structure.search;

import org.sperri.algorithms.data_structure.tree.AbstractBinaryTree;
import org.sperri.algorithms.data_structure.tree.SortedTree;

import java.util.Comparator;

/**
 * @author zj
 * @date 2020/7/12 18:10
 */
public class BinarySearchTree<E> extends AbstractBinaryTree<E>
        implements SortedTree<E> {

    @Override
    public Comparator<? super E> comparator() {
        return null;
    }

    @Override
    public SortedTree subTree(Object fromKey, Object toKey) {
        return null;
    }

    @Override
    public E root() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }
}
