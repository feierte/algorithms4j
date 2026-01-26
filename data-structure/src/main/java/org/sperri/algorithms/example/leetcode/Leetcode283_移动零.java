package org.sperri.algorithms.example.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Jie Zhao
 * @date 2026/1/20 19:44
 */
public class Leetcode283_移动零 {


    /**
     * 解法一：暴力枚举法
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] == 0 && len - i > 1) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[len - 1] = 0;
                len--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
//        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes3(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }


    /**
     * 解法一：双指针法（快慢指针）
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }

        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    /**
     * 解法一：双指针法（快慢指针）
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * <p>
     * 也是快慢指针，这样写更难体现快慢指针
     *
     * @param nums
     */
    public static void moveZeroes3(int[] nums) {

        int slow = 0, fast = 0;
        int len = nums.length;
        while (fast < len) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            } else {
                fast++;
            }
        }

        // 快指针遍历完了数组，把剩下慢指针的元素都置为 0
        while (slow < len) {
            nums[slow] = 0;
            slow++;
        }
    }
}
