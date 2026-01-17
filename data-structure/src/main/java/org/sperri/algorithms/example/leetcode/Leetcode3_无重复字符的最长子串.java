package org.sperri.algorithms.example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jie Zhao
 * @date 2026/1/17 19:49
 */
public class Leetcode3_无重复字符的最长子串 {

    /**
     * 解法一：暴力枚举
     * 时间复杂度：O(N^2)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {

        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }

        int maxSubLen = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(s.charAt(i));
            for (int j = i + 1; j < len; j++) {
                boolean success = set.add(s.charAt(j));
                if (!success) {
                    if (maxSubLen < set.size()) {
                        maxSubLen = set.size();
                    }
                    set.clear();
                    break;
                }
            }
        }
        if (maxSubLen < set.size()) {
            maxSubLen = set.size();
        }
        return maxSubLen;
    }


    /**
     * 解法一：滑动窗口 + 哈希表
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {

        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }

        int maxSubLen = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < len; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxSubLen = Math.max(maxSubLen, right - left + 1);
        }
        return maxSubLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
