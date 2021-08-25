package org.sperri.algorithms.sort;

/**
 * 冒泡排序
 * @author Jie Zhao
 * @date 2021/8/25 22:37
 */
public class BubbleSort {


    public void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                swap(array, i, i + 1);
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
    public void swap(int[] arr, int i, int j) {

    }

}
