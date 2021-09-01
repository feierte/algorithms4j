package org.sperri.algorithms.sort;

import org.sperri.algorithms.common.Printable;

import java.util.Arrays;

import static org.sperri.algorithms.util.ArrayUtils.swap;

/**
 * 冒泡排序
 *
 * @author Jie Zhao
 * @date 2021/8/25 22:37
 */
public class BubbleSort<E> extends AbstractSort<E> implements Printable {

    private E[] array;

    public BubbleSort(E[] array) {
        this.array = array;
    }

    public void sort() {
        if (array == null || array.length < 2) {
            return;
        }

        for (int end = array.length - 1; end > 0; end--) {
            boolean isSorted = true;
            for (int i = 0; i < end; i++) {
                if (compare(array[i], array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break; // 表示此次 数组中的所有元素都是有序的了，不需要再往下遍历了
            }
        }
    }


    @Override
    public void print() {
        System.out.println(
                "BubbleSort{" +
                        "array=" + Arrays.toString(array) +
                        "} ");
    }
}
