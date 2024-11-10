package org.sperri.algorithms.data_structure.tree;

import java.util.Comparator;

/**
 * @author zj
 * @date 2020/7/12 17:24
 */
public interface SortedTree<E> extends Tree<E> {

    Comparator<? super E> comparator();


    SortedTree<E> subTree(E fromKey, E toKey);
}
