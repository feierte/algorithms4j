package org.sperri.algorithms.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Jie Zhao
 * @date 2021/12/18 10:16
 */
public class ValidString_20 {

    public static boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : chars) {
            if (stack.empty()) {
                if (ch == ')' || ch == ']' || ch == '}') {
                    return false;
                }
                stack.push(ch);
            } else {
                char item = stack.peek();
                if (toMap().get(item) != null && toMap().get(item) == ch) {
                    stack.pop();
                    continue;
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.empty();
    }


    public static Map<Character, Character> toMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        return map;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("({[)"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
    }
}
