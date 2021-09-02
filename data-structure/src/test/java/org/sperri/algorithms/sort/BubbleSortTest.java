package org.sperri.algorithms.sort;

import org.junit.jupiter.api.Test;

/**
 * @author Jie Zhao
 * @date 2021/8/25 22:39
 */
public class BubbleSortTest {

    @Test
    public void test() {
        Integer[] array = new Integer[]{ 5, 3, 6, 7,2, 4, 9, 5};
        BubbleSort<Integer> sort = new BubbleSort<>(array);
        sort.sort();
        sort.print();
    }
}
