package org.sperri.algorithms.example.leetcode;

/**
 * @author Jie Zhao
 * @date 2026/1/27 20:17
 */
public class Leetcode42_接雨水 {


    /**
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param height
     * @return
     */
    public int trap(int[] height) {

        int len = height.length;
        if (len < 2) return 0;

        int[] lMax = new int[len];
        lMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            lMax[i] = Math.max(lMax[i-1], height[i]);
        }

        int[] rMax = new int[len];
        rMax[len-1] = height[len-1];
        for (int i = len-2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return res;
    }
}
