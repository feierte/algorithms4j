package org.sperri.algorithms.data_structure.string.search;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jie Zhao
 * @date 2023/9/23 9:49
 * @apiNote KMP 字符串匹配算法
 */
public class KMPSearch {

    public static void main(String[] args) {
        KMPSearch kmpSearch = new KMPSearch();
        int search = kmpSearch.search("abaacababcaa", "babc");
        System.out.println(search);
    }

    public int search(String content, String pattern) {
        if (StringUtils.isEmpty(content) || StringUtils.isEmpty(pattern)) {
            return -1;
        }
        int contentLen = content.length();
        int patternLen = pattern.length();
        if (contentLen < patternLen) {
            return -1;
        }

        int[] nextArray = getNextArray(pattern);
        char[] contentCharArray = content.toCharArray();
        char[] patternCharArray = pattern.toCharArray();
        for (int i = 0; i < contentLen; i++) {
            for (int j = 0; j < patternLen; j++) {
                // 主串移动到最后一个索引位置也没找到匹配字符串
                if (i == contentLen) {
                    return -1;
                }

                // 成功找到相匹配的字符串了，返回匹配字符串在 content 里面的索引位置
                if (j == patternLen - 1 && contentCharArray[i] == patternCharArray[j]) {
                    return i - patternCharArray.length + 1;
                }

                if (contentCharArray[i] != patternCharArray[j]) {
                    // 字符不相同时，模式字符串移动
                    j = nextArray[j] - 1;
                    if (j == -2) {
                        j = -1;
                    }
                }
                // 同时主串都要向前移动一个索引
                i++;
            }
        }
        // 没有找到相匹配的字符串
        return -1;
    }

    public int[] getNextArray(String pattern) {
        int[] nextArray = new int[pattern.length()];

        for (int i = 1; i < pattern.length(); i++) {
            int maxCommonStringLen = maxCommonStringLen(pattern.substring(0, i));
            nextArray[i] = maxCommonStringLen;
        }
        nextArray[0] = -1;
        return nextArray;
    }

    /**
     * 求字符串的最长公共子串
     *
     * @param pattern
     * @return
     */
    public int maxCommonStringLen(String pattern) {
        int len = pattern.length();
        int maxCommonStringLen = 0;
        Set<String> commonStringSet = new HashSet<>();
        for (int i = 1; i < len - 1; i++) {
            commonStringSet.add(pattern.substring(0, i));
        }

        for (int i = len - 1; i > 0; i--) {
            String substring = pattern.substring(i);
            if (!commonStringSet.add(substring)) {
                maxCommonStringLen = substring.length();
            }
        }
        return maxCommonStringLen;
    }
}
