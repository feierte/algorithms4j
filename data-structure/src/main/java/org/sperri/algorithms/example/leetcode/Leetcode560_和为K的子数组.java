package org.sperri.algorithms.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jie Zhao
 * @date 2026/1/30 21:17
 */
public class Leetcode560_和为K的子数组 {

    /**
     * 解法一：前缀和 + 哈希表
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count  = 0, sum = 0;
        // <从0到i的数组前缀和，前缀和为 k 的数有几个>
        Map<Integer, Integer> map = new HashMap<>();
        // todo 这里为什么要提前放一个进去？
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int k = -2;
        System.out.println(subarraySum(nums, k));
    }
}
