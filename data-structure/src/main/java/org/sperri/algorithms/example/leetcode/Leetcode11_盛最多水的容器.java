package org.sperri.algorithms.example.leetcode;

/**
 * @author Jie Zhao
 * @date 2026/1/26 20:35
 */
public class Leetcode11_盛最多水的容器 {


    /**
     * 解法一：暴力枚举法 (超出时间限制)
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }



    /**
     * 解法二：双指针法（对撞指针）
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int leftHeight =  height[left];
            int rightHeight = height[right];

            int area = (right - left) * Math.min(leftHeight, rightHeight);
            maxArea = Math.max(maxArea, area);

            if (leftHeight > rightHeight) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
