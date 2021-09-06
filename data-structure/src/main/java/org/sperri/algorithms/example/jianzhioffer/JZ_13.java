package org.sperri.algorithms.example.jianzhioffer;

import org.sperri.algorithms.util.ArrayUtils;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author Jie Zhao
 * @date 2021/9/3 21:59
 */
public class JZ_13 {

    public static int[] reOrderArray (int[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 1) {
            return array;
        }

        int lastOddIndex = -1; // 最后一个奇数的索引
        int lastEvenIndex = -1; // 最后一个偶数的索引

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            if (array[i] % 2 == 0) { // 偶数
                // index++;
            } else { // 奇数
                lastOddIndex++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr  = new int[] {1, 2, 3, 4};
        ArrayUtils.print(JZ_13.reOrderArray(arr));
    }
}
