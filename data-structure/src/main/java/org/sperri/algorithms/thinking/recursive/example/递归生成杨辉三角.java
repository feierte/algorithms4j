package org.sperri.algorithms.thinking.recursive.example;

/**
 * @author Jie Zhao
 * @date 2024/1/6 20:39
 */
public class 递归生成杨辉三角 {

    /**
     * 生成杨辉三角，版本一
     *
     * @param n
     */
    public static void pascalTriangle1(int n) {
        for (int i = 0; i < n; i++) {
            // printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }

    public static int element(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        }

        return element(i - 1, j - 1) + element(i - 1, j);
    }

    public static void printSpace(int n, int i) {
        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    /**
     * 生成杨辉三角，版本二：使用记忆法优化，使用二维数组
     *
     * @param n
     */
    public static void pascalTriangle2(int n) {
        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element(triangle, i, j));
            }
            System.out.println();
        }
    }

    public static int element(int[][] triangle, int i, int j) {
        if (j == 0 || i == j) {
            triangle[i][j] = 1;
            return triangle[i][j];
        }
        triangle[i][j] = element(triangle, i - 1, j - 1) + element(triangle, i - 1, j);
        return triangle[i][j];
    }


    /**
     * 生成杨辉三角，版本三：使用一维数组优化，该版本不是递归方式
     * 注意：这种方法可以称为动态规划的简单版本
     *
     * @param n
     */
    public static void pascalTriangle3(int n) {
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            createRow(row, i);
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", row[j]);
            }
            System.out.println();
        }
    }

    public static void createRow(int[] row, int i) {
        if (i == 0) {
            row[i] = 1;
            return;
        }
        for (int j = i; j > 0; j--) {
            row[j] = row[j] + row[j - 1];
        }
    }

    public static void main(String[] args) {
//        pascalTriangle1(5);
//        pascalTriangle2(5);
        pascalTriangle3(10);
    }
}
