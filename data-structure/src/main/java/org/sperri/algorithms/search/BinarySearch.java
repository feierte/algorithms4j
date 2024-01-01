package org.sperri.algorithms.search;

/**
 * @author Jie Zhao
 * @date 2021/9/3 20:12
 */
public class BinarySearch<T extends Comparable> implements Search<T> {

    private T[] array;

    public BinarySearch(T[] array) {
        this.array = array;
    }

    /**
     * 基本二分查找实现
     * @param target 待查找的目标值
     * @return
     */
    @Override
    public int search(T target) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array can not be null or empty!");
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target.compareTo(array[mid]) < 0) {
                right = mid - 1;
            } else if (array[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
