package org.sperri.algorithms.sort;

import java.util.Comparator;

/**
 * @author Jie Zhao
 * @date 2021/8/26 19:44
 */
public abstract class AbstractSort<E extends Comparable<E>> implements Sort<E> {

    protected Comparator<? super E> comparator;

    public AbstractSort() {}

    protected AbstractSort(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    protected int compare(E o1, E o2) {
        return this.comparator == null ? ((Comparable<E>) o1).compareTo(o2) :
                this.comparator.compare(o1, o2);
    }

    @Override
    public boolean isSorted() {
        return false;
    }
}
