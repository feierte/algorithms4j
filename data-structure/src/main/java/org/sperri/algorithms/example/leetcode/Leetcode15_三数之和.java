package org.sperri.algorithms.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * @author Jie Zhao
 * @date 2026/1/15 20:39
 */
public class Leetcode15_三数之和 {


    /**
     * 解法一：暴力穷举法，超出了 leetcode 的时间限制
     * 时间复杂度：O(N^4)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        // 排序，排序是为了方便去重
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Integer[] sortedInts = {nums[i], nums[j], nums[k]};
                        // 排序后进行比较，相等就意味着重复
                        boolean isEqual = false;
                        for (List<Integer> list : result) {
                            if (list.get(0) == sortedInts[0]
                                    && list.get(1) == sortedInts[1]
                                    && list.get(2) == sortedInts[2]) {
                                isEqual = true;
                                break;
                            }
                        }
                        // 没有重复才加入结果中
                        if (!isEqual) {
                            result.add(List.of(sortedInts));
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 解法二：排序 + 双指针，自己写的，是错误的
     * 时间复杂度：O(N^4)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        // 先排序，使用数组有序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        // 一层循环，先固定一个数，使用双指针在数组的剩余空间里面移动；
        // 相当于把问题转换为在有序数组里面做一次两数之和，用双指针凑出目标值
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -1 * nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    Integer[] sortedInts = {nums[i], nums[left], nums[right]};
                    // 排序后进行比较，相等就意味着重复
                    boolean isEqual = false;
                    for (List<Integer> list : result) {
                        if (list.get(0) == sortedInts[0]
                                && list.get(1) == sortedInts[1]
                                && list.get(2) == sortedInts[2]) {
                            isEqual = true;
                            break;
                        }
                    }
                    // 没有重复才加入结果中
                    if (!isEqual) {
                        result.add(List.of(sortedInts));
                    }
                }
                // 同时移动左右指针？错误的，为什么左右指针不能同时移动？
                left++;
                right--;
            }
        }
        return result;
    }


    /**
     * 解法二：排序 + 双指针
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        // 先排序，使用数组有序，从小到大排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        // 一层循环，先固定一个数，使用双指针在数组的剩余空间里面移动；
        // 相当于把问题转换为在有序数组里面做一次两数之和，用双指针凑出目标值
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果前一个数和后一个数相同就跳过，why？找个数组示例在白纸上面走一遍代码流程
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 剪枝，对于有序数组才有效，所以第一步要排序
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    // 三数之和小于 0，说明需要更大的数，移动左指针
                    left++;
                    // 为了去重
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum > 0) {
                    // 三数之和大于 0，说明需要更小的数，移动右指针
                    right--;
                    // 为了去重
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    // 找到了，记录这组解
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    // 同时移动左右指针
                    left++;
                    right--;

                    // 找到一组解后，左右指针跳过重复的值，这样才能保证不重解，why？
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
