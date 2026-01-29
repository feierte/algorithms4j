package org.sperri.algorithms.example.leetcode;

import java.util.*;

/**
 * @author Jie Zhao
 * @date 2026/1/27 20:38
 */
public class Leetcode438_找到字符串中所有字母异位词 {


    /**
     * 解法一：滑动窗口（没有通过）
     * 时间复杂度：O(N*M)
     * 空间复杂度：O(1)
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int pLen = p.length();
        // <字符串， 出现的次数>
        Map<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        // <字符串， 出现的次数>
        Map<Character, Integer> sMap = new HashMap<>();
        while (right < s.length()) {
            if (pMap.containsKey(s.charAt(right))) {
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            if (right - left + 1 == pLen) {
                // 比较两个是否是异位词
                int valid = 0;
                for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
                    Character key = entry.getKey();
                    Integer value = entry.getValue();
                    if (sMap.get(key) == value) {
                        valid++;
                    }
                }
                if (valid == pMap.size()) {
                    result.add(left);
                }
                if (sMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left),  sMap.get(s.charAt(left)) - 1);
                }
                left++;
            }
            right++;
        }
        return result;
    }


    /**
     * 解法一：滑动窗口（没有通过）
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams2(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int pLen = p.length();
        // <字符串， 出现的次数>
        Map<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        // <字符串， 出现的次数>
        Map<Character, Integer> sMap = new HashMap<>();
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (pMap.containsKey(c)) {
                Integer count = sMap.getOrDefault(c, 0);
                sMap.put(c, count + 1);
                if (sMap.get(c).equals(pMap.get(c))) {
                    valid++;
                }
            }

            left = right - pLen + 1;
            right++;
            if (left < 0) {
                continue;
            }
            if (valid == pMap.size()) {
                result.add(left);
            }
            char c1 = s.charAt(left);
            if (pMap.containsKey(c1)) {
                Integer count = sMap.get(c1);
                if (count.equals(pMap.get(c1))) {
                    valid--;
                }
                sMap.put(c1, --count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams2(s, p));
    }
}
