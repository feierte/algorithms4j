package org.sperri.algorithms.example.leetcode;

/**
 * @author Jie Zhao
 * @date 2021/12/17 17:26
 */
public class PalindromeInteger_09 {

    /**
     * 普通解法：整数转为字符串，然后字符串反转，之后比较
     * @param x
     * @return
     */
    /*public static boolean isPalindrome(int x) {

        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);

        return str.equals(sb.reverse().toString());
    }
*/
    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int num = x;
        while (num != 0) {
            int temp = num % 10;
            reverse = reverse * 10 + temp;
            num = num / 10;
        }
        return reverse == x;
    }

    public static void main(String[] args) {
        // System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(121));
    }
}
