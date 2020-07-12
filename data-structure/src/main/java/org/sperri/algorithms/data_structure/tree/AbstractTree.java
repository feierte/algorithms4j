package org.sperri.algorithms.data_structure.tree;

/**
 * @author zj
 * @date 2020/7/12 16:37
 */
public abstract class AbstractTree<K, V> implements Tree<K, V> {

    public boolean isEmpty() {
        return size() == 0;
    }
}
