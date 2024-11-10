package org.sperri.algorithms.data_structure.tree;

/**
 * @author zj
 * @date 2020/7/12 11:13
 */
public interface Tree<E> {

    /**
     * 树的根节点
     * @return
     */
    E root();

    /**
     * return the numbers of node in this tree. if the tree
     * @return
     */
    int size();

    boolean isEmpty();

    /**
     * 当前树的高度
     * @return
     */
    int height();
}
