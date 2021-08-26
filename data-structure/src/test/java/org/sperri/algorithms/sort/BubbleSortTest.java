package org.sperri.algorithms.sort;

import org.junit.jupiter.api.Test;

/**
 * @author Jie Zhao
 * @date 2021/8/25 22:39
 */
public class BubbleSortTest {

    @Test
    public void test() {
        Integer[] array = new Integer[]{2, 8, 3, 6, 3, 5, 9};
        BubbleSort bubbleSort = new BubbleSort(array);
        bubbleSort.sort();
        bubbleSort.print();
    }
}
