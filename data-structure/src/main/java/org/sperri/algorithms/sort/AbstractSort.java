package org.sperri.algorithms.sort;

import java.util.Comparator;

public abstract class AbstractSort<E> implements Sort, Printable {

    protected Comparator<? super E> comparator;

    protected AbstractSort() {
    }

    protected AbstractSort(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }


    /**
     * 比较两个数的大小
     *
     * @param o1
     * @param o2
     * @return
     */
    protected int compare(E o1, E o2) {
        return comparator == null ? ((Comparable<E>) o1).compareTo(o2) :
                comparator.compare((E) o1, (E) o2);
    }

    public Comparator<? super E> comparator() {
        return comparator;
    }
}
