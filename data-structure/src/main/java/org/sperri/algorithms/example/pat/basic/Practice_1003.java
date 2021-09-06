package org.sperri.algorithms.example.pat.basic;

import java.util.Scanner;

/**
 * 我要通过！
 * <p>
 * “答案正确”是自动判题系统给出的最令人欢喜的回复。本题属于 PAT 的“答案正确”大派送 —— 只要读入的字符串满足下列条件，系统就输出“答案正确”，否则输出“答案错误”。
 * <p>
 * 得到“答案正确”的条件是：
 * <p>
 * 1.字符串中必须仅有 P、 A、 T这三种字符，不可以包含其它字符；
 * 2.任意形如 xPATx 的字符串都可以获得“答案正确”，其中 x 或者是空字符串，或者是仅由字母 A 组成的字符串；
 * 3.如果 aPbTc 是正确的，那么 aPbATca 也是正确的，其中 a、 b、 c 均或者是空字符串，或者是仅由字母 A 组成的字符串。
 * <p>
 * 现在就请你为 PAT 写一个自动裁判程序，判定哪些字符串是可以获得“答案正确”的。
 * 输入格式：
 * 每个测试输入包含 1 个测试用例。第 1 行给出一个正整数 n (<10)，是需要检测的字符串个数。接下来每个字符串占一行，字符串长度不超过 100，且不包含空格。
 * <p>
 * 输出格式：
 * 每个字符串的检测结果占一行，如果该字符串可以获得“答案正确”，则输出 YES，否则输出 NO。
 *
 * @author Jie Zhao
 * @date 2021/9/3 13:51
 */
public class Practice_1003 {

    public String isCorrect(String input) {

        return "YES";
    }


    public static void main(String[] args) {
        Practice_1003 practice1003 = new Practice_1003();
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if (count <= 0 || count >= 10) {
            throw new IllegalArgumentException();
        }


        for (int i = 0; i < count; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(practice1003.isCorrect(line));
            }
        }
    }
}
