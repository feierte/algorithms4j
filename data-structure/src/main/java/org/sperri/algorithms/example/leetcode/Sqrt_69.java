package org.sperri.algorithms.example.leetcode;

/**
 * @author Jie Zhao
 * @date 2021/12/18 14:09
 */
public class Sqrt_69 {

    public static int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        int lo = 0;
        int hight = x - 1;

        while (lo <= hight) {
            int middle = (lo + hight) / 2;
            if (middle * middle < x && middle * middle >= 0) {
                lo = middle + 1;
            } else if (middle * middle > x || middle * middle < 0) {
                hight = middle - 1;
            }
        }
        return hight;
    }

    public static void main(String[] args) {
         //System.out.println(Sqrt_69.mySqrt(8));
        //System.out.println(Sqrt_69.mySqrt(3));
        //System.out.println(Sqrt_69.mySqrt(2));
        //System.out.println(Sqrt_69.mySqrt(1));
        System.out.println(Sqrt_69.mySqrt(2147395599));

        System.out.println(268424450 * 268424450);
        System.out.println(46339 * 46339);
    }
}
