package org.sperri.algorithms.example.pat.basic;

import java.util.Scanner;
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

        int sum = 0;
        while (n != 0) {
            int remainder = n % 10; // 余数
            n = n / 10; //
            sum += remainder;
        }

        StringBuilder builder = new StringBuilder();
        while (sum != 0) {
            int remainder = sum % 10; // 余数
            sum = sum / 10; //
            builder.append(remainder+"");
        }


        StringBuilder result = new StringBuilder();
        StringBuilder reverse = builder.reverse();
        for (int i = 0; i < reverse.length(); i++) {
            char c = reverse.charAt(i);
            Digit digit = Digit.getDigitByNum(c);
            result.append(digit.getPinyi()).append(" ");
        }

        return result.substring(0, result.lastIndexOf(" "));
    }

    enum Digit {

        ZERO('0', "lin"), ONE('1', "yi"),
        TWO('2', "er"), THREE('3', "san"),
        FOUR('4', "si"), FIVE('5', "wu"),
        SIX('6', "liu"), SEVEN('7', "qi"),
        EIGHT('8', "ba"), NINE('9', "jiu");

        private char arabicNumber; // 阿拉伯数字
        private String pinyi; // 中文数字拼音

        Digit(char arabicNumber, String pinyi) {
            this.arabicNumber = arabicNumber;
            this.pinyi = pinyi;
        }

        public static Digit getDigitByNum(int number) {
            for (Digit value : values()) {
                if (value.arabicNumber == number) {
                    return value;
                }
            }
            return null;
        }

        public int getArabicNumber() {
            return arabicNumber;
        }

        public String getPinyi() {
            return pinyi;
        }
    }

    public static void main(String[] args) {
        Practice_1002 practice_1002 = new Practice_1002();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(practice_1002.digitsSum(n));
        }
    }
}
