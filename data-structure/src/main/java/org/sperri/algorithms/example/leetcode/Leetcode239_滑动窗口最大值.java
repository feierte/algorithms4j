package org.sperri.algorithms.example.leetcode;

import org.sperri.algorithms.data_structure.queue.ArrayQueue;
import org.sperri.algorithms.data_structure.queue.LinkedQueue;

import java.util.*;

/**
 * @author Jie Zhao
 * @date 2026/1/31 16:55
 */
public class Leetcode239_滑动窗口最大值 {

    /**
     * 解法一：暴力枚举法 (超出时间限制)
     * 时间复杂度：O(N * K)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        for (int right = k - 1; right < nums.length; right++) {
            int maxK = Integer.MIN_VALUE;
            if (k >= nums.length) {
                right = nums.length - 1;
            }
            for (int i = left; i <= right; i++) {
                maxK = Math.max(maxK, nums[i]);
            }
            res[left] = maxK;
            left++;
        }
        return res;
    }


    /**
     * 解法二：最大堆（超出时间限制）
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int r = 0; r < nums.length; r++) {
            pq.add(nums[r]);
            if (r - l + 1 >= k) {
                res[l] = pq.peek();
                pq.remove(nums[l]);
                l++;
            }
        }
        return res;
    }


    /**
     * 解法三：
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // 单调队列，队首存储最大元素的索引
        Deque<Integer> queue = new LinkedList<>();
        for (int r = 0; r < nums.length; r++) {
            while (!queue.isEmpty() && nums[r] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(r);

            // k 窗口还未满
            int l = r - k + 1;
            if (l < 0) {
                continue;
            }

            if (l > queue.peekFirst()) {
                queue.pollFirst();
            }

            res[l] = nums[queue.peek()];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {3, 1, 1, 3};
        int k = 3;
        Arrays.stream(maxSlidingWindow3(nums, k)).forEach(System.out::println);
    }
}
