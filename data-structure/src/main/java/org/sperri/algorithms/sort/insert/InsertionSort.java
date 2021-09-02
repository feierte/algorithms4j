package org.sperri.algorithms.sort.insert;

import org.sperri.algorithms.common.Printable;
import org.sperri.algorithms.sort.AbstractSort;

import java.util.Arrays;

import static org.sperri.algorithms.util.ArrayUtils.move;
import static org.sperri.algorithms.util.ArrayUtils.swap;

/**
 * 插入排序
 * @author Jie Zhao
 * @date 2021/8/28 10:56
 */
public class InsertionSort<E> extends AbstractSort<E> implements Printable {

    private E[] array;

    public InsertionSort(E[] array) {
        this.array = array;
    }

    @Override
    public void sort() {
        if (array == null || array.length < 1) {
            return;
        }

        E temp = null;
        // 注意是从数组中第二个元素开始遍历
        for (int end = 1; end < array.length; end++) {
            temp = array[end];
            for (int i = 0; i < end; i++) {
                if (compare(array[i], temp) > 0) {
                    move(array, i, end - 1);
                    array[i] = temp;
                    break; // 一次循环就插入一个元素
                }
            }
        }
    }

    @Override
    public void print() {
        System.out.println(
                "InsertionSort{" +
                        "array=" + Arrays.toString(array) +
                        "} ");
    }
}
