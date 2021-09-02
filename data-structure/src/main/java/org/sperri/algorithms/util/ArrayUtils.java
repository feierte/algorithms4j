package org.sperri.algorithms.util;

import java.util.Objects;

/**
 * 数组工具类
 * @author Jie Zhao
 * @date 2021/8/28 8:48
 */
public class ArrayUtils {

    private ArrayUtils(){}


    /**
     * 交换数组中任意两个元素的位置
     *
     * @param arr
     * @param i
     * @param j
     */
    public static <T> void swap(T[] arr, int i, int j) {
        if (Objects.isNull(arr)) {
            throw new NullPointerException();
        }

        if (i >= arr.length || j >= arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 数组中元素 arr[begin, end]向后移动一位
     * @param arr
     * @param begin
     * @param end
     * @param <T>
     */
    public static <T> void move(T[] arr, int begin, int end) {
        if (Objects.isNull(arr)) {
            throw new NullPointerException();
        }

        if (begin >= arr.length || (end + 1) >= arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = end; i >= begin; i--) {
            arr[ i + 1 ] = arr[i];
        }
    }
}
