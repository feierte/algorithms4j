package org.sperri.algorithms.example.leetcode;

/**
 * 整数反转 leetcode 第7题
 * @author Jie Zhao
 * @date 2021/12/17 17:17
 */
public class IntegerReverse {

    public static int reverse(int x) {
        int resut = 0;
        while (x != 0) {
            // 每次取末尾数字
            int tmp = x % 10;

            // 判断是否 大于 最大32位整数
            if (resut > Integer.MAX_VALUE || (resut == Integer.MAX_VALUE && tmp > 7)) {
                return 0;
            }
            // 判断是否 小于 最小32位整数
            if (resut < Integer.MIN_VALUE || (resut == Integer.MIN_VALUE && tmp < -8)) {
                return 0;
            }

            resut = resut * 10 + tmp;
            x = x / 10;
        }
        return resut;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
