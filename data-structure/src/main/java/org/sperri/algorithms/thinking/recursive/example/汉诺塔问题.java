package org.sperri.algorithms.thinking.recursive.example;

import java.util.Stack;

/**
 * 使用递归思想求解汉诺塔问题
 *
 * @author Jie Zhao
 * @date 2024/1/6 20:06
 */
public class 汉诺塔问题 {


    /**
     * 将 a 上圆盘，移动到 c 上面，借助于 b
     *
     * @param n 圆盘个数
     * @param a 圆盘的原始位置
     * @param b 圆盘的借助位置
     * @param c 圆盘的目标位置
     */
    public static void hanoi(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, a, c, b);
        c.push(a.pop());
        hanoi(n - 1, b, a, c);
    }


    public static void main(String[] args) {
        int n = 3;
        Stack<Integer> a = new Stack<>();
        for (int i = n; i > 0; i--) {
            a.push(i);
        }
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();
        print(a, b, c);
        hanoi(3, a, b, c);
        print(a, b, c);
    }

    public static void print(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("=====================");
    }
}
