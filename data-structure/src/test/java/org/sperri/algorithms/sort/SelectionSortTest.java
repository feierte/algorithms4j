package org.sperri.algorithms.sort;

import org.junit.jupiter.api.Test;

/**
 * @author Jie Zhao
 * @date 2021/8/28 10:55
 */
public class SelectionSortTest {

    @Test
    public void test() {
        Integer[] array = new Integer[]{ 5, 3, 6, 7, 2, 4, 9, 5};
        SelectionSort<Integer> sort = new SelectionSort<>(array);
        sort.sort();
        sort.print();
    }
}
