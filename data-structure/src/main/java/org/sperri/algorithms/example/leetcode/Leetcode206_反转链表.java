package org.sperri.algorithms.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jie Zhao
 * @date 2026/5/28 15:01
 */
public class Leetcode206_反转链表 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /**
     * 思路：将链表中的元素放到栈中，通过栈的特性反转链表，然后在组合成一个新的链表。
     * 没有做出来
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Deque<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);

            ListNode next = cur.next;
            if (next != null) {
                cur.next = null;
                cur = next;
            }
//            if (cur != null) {
//                cur.next = queue.peekLast();
//            }
        }

        ListNode reverseList = queue.getLast();
        ListNode p = reverseList;
        while (!queue.isEmpty()) {
            p.next = queue.getLast();
        }

        return reverseList;
    }


    /**
     * 三指针法
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode p = null;
        ListNode next;
        while (head != null) {
            next = head.next; // 暂存下一个节点
            head.next = p; // 反转指针

            p = head; // p 指针前进
            head = next; // head 指针前进
        }
        return p;
    }
}
