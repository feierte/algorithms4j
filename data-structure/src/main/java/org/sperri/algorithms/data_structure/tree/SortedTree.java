package org.sperri.algorithms.data_structure.tree;

import java.util.Comparator;

/**
 * @author zj
 * @date 2020/7/12 17:24
 */
public interface SortedTree<K, V> extends Tree<K, V> {

    Comparator<? super K> comparator();


    SortedTree<K, V> subTree(K fromKey, K toKey);
}
