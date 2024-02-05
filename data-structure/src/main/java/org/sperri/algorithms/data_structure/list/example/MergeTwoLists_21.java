package org.sperri.algorithms.data_structure.list.example;

/**
 * 合并两个有序链表
 *
 * @author Jie Zhao
 * @date 2024/2/5 9:28
 * @link <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/">...</a>
 */
public class MergeTwoLists_21 {

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(2, 3, 4);
        ListNode list2 = ListNode.of(1, 2, 5);
        list1.print();
        list2.print();
        mergeTwoLists(list1, list2).print();
    }

    /**
     * 方法一：双指针，一个指针指向 list1，一个指针指向 list2
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode sentinel1 = new ListNode(-1, list1);
        ListNode sentinel2 = new ListNode(-1, list2);
        ListNode p1 = sentinel1;
        ListNode p2 = sentinel2;
        // 把 list2 链表上面的元素，插入到 list1 链表中合适的位置
        while (p1.next != null) {
            if (p2.next == null) {
                break; // list2 链表遍历结束了，返回即可
            }

            if (p2.next.val < p1.next.val) {
                // 插入到 list1 中
                ListNode next = p2.next;
                p2.next = next.next; // p2 next 结点向前移动
                next.next = p1.next;
                p1.next = next;
                p1 = p1.next; // p1 指针向前移动
            } else {
                p1 = p1.next; // p1 指针向前移动
                if (p1.next == null) {
                    // list1 遍历结束了，将 list2 剩余结点都移动到 list1 后面
                    p1.next = p2.next;
                    break;
                }
            }
        }

        return sentinel1.next;
    }
}
