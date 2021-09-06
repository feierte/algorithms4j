package org.sperri.algorithms.search;

/**
 * @author Jie Zhao
 * @date 2021/9/3 20:12
 */
public class BinarySearch<T> implements Search<T> {

    private T[] array;

    public BinarySearch(T[] array) {
        this.array = array;
    }

    @Override
    public int search(T target) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array can not be null or empty!");
        }

        int left = 0;
        int right = array.length;

        while (left <= right) {

        }

        return 0;
    }
}
