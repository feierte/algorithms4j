package org.sperri.algorithms.data_structure.list.example;

/**
 * @author Jie Zhao
 * @date 2024/1/7 14:59
 */
public class 移除单向链表元素 {

    /**
     * 方法一：暴力求解法，迭代遍历
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr == head && curr.val == val) {
                head = head.next;
                curr = head;
                prev = null;
            } else if (curr.val == val) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }


    /**
     * 方法一：暴力求解法，迭代遍历
     * 手动添加一个哨兵，使代码更简洁
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr == head && curr.val == val) {
                head = head.next;
                curr = head;
                prev = null;
            } else if (curr.val == val) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
