package org.sperri.algorithms.data_structure.list.example;

/**
 * 合并K个有序链表
 *
 * @author Jie Zhao
 * @date 2024/2/5 9:59
 * @link <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">...</a>
 */
public class MergeKLists_23 {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6)
        };
        mergeKLists(lists).print();
    }

    /**
     * 方法一：分治思想，使用多路递归实现
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKListsRecursively(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKListsRecursively(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int m = (left + right) >>> 1;
        ListNode mergedLeft = mergeKListsRecursively(lists, left, m);
        ListNode mergedRight = mergeKListsRecursively(lists, m + 1, right);
        return MergeTwoLists_21.mergeTwoLists(mergedLeft, mergedRight);
    }
}
