package org.sperri.algorithms.example.pat.basic;

import java.util.StringJoiner;

/**
 * 写出这个数
 *
 * 读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，即给出自然数 n 的值。这里保证 n 小于 10^100。
 *
 * 输出格式：
 * 在一行内输出 n 的各位数字之和的每一位，拼音数字间有 1 空格，但一行中最后一个拼音数字后没有空格。
 *
 * @author Jie Zhao
 * @date 2021/9/1 22:00
 */
public class Practice_1002 {

    public String digitsSum(int n) {
        if (n < 0 || n >= Math.pow(10, 100)) {
            throw new IllegalArgumentException("argument may between in [0, 10^100)");
        }

        /**
         * while(n) {
         *     n % 2; // n的二进制中的一位
         *     n /= 2;
         * }
         */

        StringJoiner joiner = new StringJoiner(" ");
        int remainder = n % 10;
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE - Math.pow(10, 100));
        System.out.println(Long.MAX_VALUE - Math.pow(10, 100));
    }
}
