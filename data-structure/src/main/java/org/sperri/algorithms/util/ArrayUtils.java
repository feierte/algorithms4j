package org.sperri.algorithms.util;

import java.util.Objects;

/**
 * 数组工具类
 *
 * @author Jie Zhao
 * @date 2021/8/28 8:48
 */
public class ArrayUtils {

    private ArrayUtils() {
    }


    /**
     * 交换数组中任意两个元素的位置
     *
     * @param arr
     * @param i
     * @param j
     */
    public static <T> void swap(T[] arr, int i, int j) {

        checkIndexOutOfBounds(arr, i);
        checkIndexOutOfBounds(arr, j);

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(int[] arr, int i, int j) {

        checkIndexOutOfBounds(arr, i);
        checkIndexOutOfBounds(arr, j);

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 数组中元素 arr[begin, end]向后移动一位
     *
     * @param arr
     * @param begin
     * @param end
     * @param <T>
     */
    public static <T> void move(T[] arr, int begin, int end) {

        checkIndexOutOfBounds(arr, begin);
        checkIndexOutOfBounds(arr, end + 1);

        for (int i = end; i >= begin; i--) {
            arr[i + 1] = arr[i];
        }
    }


    public static void move(int[] arr, int begin, int end) {

        checkIndexOutOfBounds(arr, begin);
        checkIndexOutOfBounds(arr, end + 1);

        for (int i = end; i >= begin; i--) {
            arr[i + 1] = arr[i];
        }
    }


    /**
     * 判断数组是否为空
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> boolean isEmpty(T[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断数组是否是有序的
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }


    public static void print(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 数组是否为null
     *
     * @param arr
     * @param <T>
     */
    public static <T> void checkNotNull(T[] arr) {
        if (Objects.isNull(arr)) {
            throw new NullPointerException("数组为null!");
        }
    }

    public static void checkNotNull(int[] arr) {
        if (Objects.isNull(arr)) {
            throw new NullPointerException("数组为null!");
        }
    }

    /**
     * 是否数组越界了
     *
     * @param arr
     * @param index
     * @param <T>
     */
    public static <T> void checkIndexOutOfBounds(T[] arr, int index) {
        checkNotNull(arr);
        if (index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public static void checkIndexOutOfBounds(int[] arr, int index) {
        checkNotNull(arr);
        if (index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }
}
