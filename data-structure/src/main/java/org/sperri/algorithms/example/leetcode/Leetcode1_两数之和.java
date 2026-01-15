package org.sperri.algorithms.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jie Zhao
 * @date 2026/1/15 20:20
 */
public class Leetcode1_两数之和 {


    /**
     * 解法一：穷举法
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {

        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 解法二：哈希表
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * <p>
     * 思路：解法一 一次循环只能比较两个数，如果一次能够比较 n 个数就好了
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
