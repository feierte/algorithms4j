package org.sperri.algorithms.sort;

import org.junit.jupiter.api.Test;
import org.sperri.algorithms.sort.insert.InsertionSort;

/**
 * @author Jie Zhao
 * @date 2021/8/28 11:06
 */
public class InsertionSortTest {

    @Test
    public void test() {
        Integer[] array = new Integer[]{ 5, 3, 6, 7, 2, 4, 9, 5};
        InsertionSort<Integer> sort = new InsertionSort<>(array);
        sort.sort();
        sort.print();
    }
}
