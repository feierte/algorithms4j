package org.sperri.algorithms.example.leetcode;

/**
 * @author Jie Zhao
 * @date 2021/12/17 18:47
 */
public class LongestCommonPrefix_14 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            String ch = strs[0].substring(i, i + 1);

            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (i >= str.length()) {
                    return result;
                }
                if (!ch.equals(str.substring(i, i + 1))) {
                    return result;
                }
            }
            result = result + ch;
        }
        return result;
    }


    public static void main(String[] args) {
        // System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
    }
}
