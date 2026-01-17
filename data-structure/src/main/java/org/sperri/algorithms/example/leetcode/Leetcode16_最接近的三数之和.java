package org.sperri.algorithms.example.leetcode;

import java.util.Arrays;

/**
 * @author Jie Zhao
 * @date 2026/1/17 16:46
 */
public class Leetcode16_最接近的三数之和 {


    /**
     * 解法一：暴力穷举法
     * 时间复杂度：O(N^3)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest1(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (k == 2) {
                        closest = sum;
                        continue;
                    }
                    if (Math.abs(sum - target) < Math.abs(closest - target)) {
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }


    /**
     * 解法二：排序 + 双指针（对撞指针）
     * 时间复杂度：O(N^2)，O(N^2)，其中 N 是数组 nums 的长度。我们首先需要 O(NlogN) 的时间对数组进行排序，随后在枚举的过程中，
     * 使用一重循环 O(N) 枚举 a，双指针 O(N) 枚举 b 和 c，故一共是 O(N^2)。
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest2(int[] nums, int target) {
        // 先排序
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    closest = sum;
                    break;
                }

                // 找到更接近的值了
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum > target) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {10,20,30,40,50,60,70,80,90};
        int target = 1;
        System.out.println(threeSumClosest2(nums, target));
    }
}
