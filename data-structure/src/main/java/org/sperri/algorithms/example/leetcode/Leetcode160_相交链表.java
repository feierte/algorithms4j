package org.sperri.algorithms.example.leetcode;

/**
 * @author Jie Zhao
 * @date 2026/5/28 11:17
 */
public class Leetcode160_相交链表 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 错误
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        while (true) {
            if (curA == null) {
                curA = headB;
            }

            if (curB == null) {
                curB = headA;
            }

            if (curA == curB) {
                return curA;
            }

            curA = curA.next;
            curB = curB.next;
        }
    }


    /**
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
        }
        return curA;
    }

    public static void main(String[] args) {

    }
}
