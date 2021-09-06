package org.sperri.algorithms.example.jianzhioffer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Jie Zhao
 * @date 2021/9/3 14:08
 */
public class JZ7 {

    // 方法一：递归
    /*public static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }*/


    // 方法二：记忆化搜索
    public static int fibonacci(int n, Map<Integer, Integer> fbMap) {

        if (fbMap.get(n) != null) {
            return fbMap.get(n);
        }

        if (n == 0 || n == 1) {
            fbMap.put(n, n);
            return n;
        }

        fbMap.put(n, fibonacci(n-1, fbMap) + fibonacci(n-2, fbMap));

        return fbMap.get(n);
    }

    // todo：动态规划

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> fbMap = new HashMap<>();
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            System.out.println(fibonacci(i, fbMap));
        }
    }
}
