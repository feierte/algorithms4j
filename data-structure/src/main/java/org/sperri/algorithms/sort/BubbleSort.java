package org.sperri.algorithms.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 冒泡排序
 *
 * @author Jie Zhao
 * @date 2021/8/25 22:37
 */
public class BubbleSort<E> extends AbstractSort<E> {


    private E[] array;


    public BubbleSort(E[] array) {
        this.array = array;
    }


    public BubbleSort(Collection<? extends E> collection) {
        array = collection.toArray(array);
    }


    /**
     * 冒泡排序
     */
    public void sort() {
        if (array == null || array.length < 2) {
            return;
        }

        // 表示是否已经是有序的了
        boolean isSorted = true; // 优化：如果已经是有序的，就不需要在继续进行冒泡了，直接返回
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (compare(array[i], array[i+1]) > 0) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            if (!isSorted) {

            }
        }
    }


    /**
     * 交换数组中任意两个元素的位置
     *
     * @param arr
     * @param i
     * @param j
     */
    public void swap(E[] arr, int i, int j) {

        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void print() {
        System.out.println(
                "BubbleSort{" +
                        "array=" + Arrays.toString(array) +
                        '}'
        );
    }
}
