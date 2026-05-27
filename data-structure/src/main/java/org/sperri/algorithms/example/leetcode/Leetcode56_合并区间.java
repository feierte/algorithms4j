package org.sperri.algorithms.example.leetcode;

import java.util.*;

/**
 * @author Jie Zhao
 * @date 2026/5/26 20:41
 */
public class Leetcode56_合并区间 {

    /**
     * 排序 + 枚举（错误）
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
//        Map<Integer, int[]> orderedIntervals = new TreeMap<>();
//        for (int i = 0; i < intervals.length; i++) {
//            orderedIntervals.put(intervals[i][0], intervals[i]);
//        }

        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));

        List<int[]> nonOverlaps = new ArrayList<>();
        Set<Integer> overlaps = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            if (overlaps.contains(i)) {
                continue;
            }
            for (int j = i + 1; j < intervals.length; j++) {
                int start1 = intervals[i][0];
                int end1 = intervals[i][intervals[i].length - 1];
                int start2 = intervals[j][0];
                int end2 = intervals[j][intervals[j].length - 1];

                if ((start1 <= start2 && start2 <= end2) ||
                        (start2 <= start1 && start2 <= end1)
                       /* (start1 <= start2 && end1 >= end2) ||
                        (start2 <= start1 && end2 >= end1)*/) {
                    int[] nonOverlap = {Math.min(start1, start2), Math.max(end1, end2)};
                    nonOverlaps.add(nonOverlap);
                }
            }
        }
        return nonOverlaps.toArray(new int[0][]);
    }


    /**
     *
     * @param intervals
     * @return
     */
    public static int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
        List<int[]> nonOverlaps = new ArrayList<>();
        nonOverlaps.add(intervals[0]);

        for (int[] interval : intervals) {
            int[] preInterval = nonOverlaps.get(nonOverlaps.size() - 1);
            // 当前区间的左边界 < 上一个区间的右边界；说明有重叠
            if (interval[0] < preInterval[1]) {
                preInterval[1] = Math.max(interval[1], preInterval[1]);
            } else {
                nonOverlaps.add(interval);
            }
        }
        return nonOverlaps.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals).toString());
    }
}
