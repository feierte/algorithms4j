package org.sperri.algorithms.sort;

/**
 * @author Jie Zhao
 * @date 2021/8/26 19:44
 */
public interface Sort<E> {

    void sort();

    /**
     * 是否是有序的
     * @return
     */
    boolean isSorted();
}
