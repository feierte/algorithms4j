package org.sperri.algorithms.example.leetcode;

/**
 * @author Jie Zhao
 * @date 2026/5/27 9:59
 */
public class Leetcode189_轮转数组 {

    /**
     * 错误
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int shift = (k + i) % nums.length + 1;
            result[shift] = nums[i];
        }
        nums = result;
    }


    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
