package org.sperri.algorithms.example.leetcode;

/**
 * @author Jie Zhao
 * @date 2026/5/28 10:57
 */
public class Leetcode238_除了自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {

        int[] l = new int[nums.length];
        l[0] = 1;
        int[] r = new int[nums.length];
        r[nums.length - 1] = 1;
        int[] answer = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }

        for (int i = nums.length - 2; i > 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = l[i] * r[i];
        }
        return answer;
    }
}
