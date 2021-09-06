package org.sperri.algorithms.sort;

import org.sperri.algorithms.common.Printable;

import java.util.Arrays;

import static org.sperri.algorithms.util.ArrayUtils.swap;

/**
 * 选择排序
 * @author Jie Zhao
 * @date 2021/8/28 10:47
 */
public class SelectionSort<E extends Comparable<E>> extends AbstractSort<E> implements Printable {


    private E[] array;

    public SelectionSort(E[] array) {
        this.array = array;
    }

    @Override
    public void sort() {
        if (array == null || array.length < 2) {
            return;
        }

        // array[0...i) 是有序的，array[i...n) 是无序的
        for (int i = 0; i < array.length; i++) {
            // 选择 array[i...n) 中的最小值的索引
            int minIndex = i; // 当前循环中，数组中最小元素的索引位置
            for (int j = i + 1; j < array.length; j++) {
                if (compare(array[minIndex], array[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    @Override
    public void print() {
        System.out.println(
                "SelectionSort{" +
                        "array=" + Arrays.toString(array) +
                        "} ");
    }
}
