package org.sperri.algorithms.example.leetcode;

/**
 * @author Jie Zhao
 * @date 2021/12/18 11:02
 */
public class MergeTwoLists_21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                head = add(head, new ListNode(list2.val));
                list2 = list2.next;
            } else {
                head = add(head, new ListNode(list1.val));
                list1 = list1.next;
            }
        }

        if (list2 != null) {
            head = add(head, list2);
        }

        if (list1 != null) {
            head = add(head, list1);
        }
        return head;
    }

    public static ListNode add(ListNode head, ListNode node) {
        ListNode newHead = head;
        ListNode last = null;

        if (head == null) {
            head = node;
        } else {
            while (newHead != null) {
                last = newHead;
                newHead = newHead.next;
            }
            last.next = node;
        }
        return head;
    }


    public static class ListNode {
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

    public static ListNode buildList(int[] array) {
        ListNode head = null;
        ListNode tempHead = null;
        for (int i = 0; i < array.length; i++) {
            if (head == null) {
                head = new ListNode(array[i]);
                tempHead = head;
            } else {
                ListNode last = null;
                tempHead = head;
                while (tempHead != null) {
                    last = tempHead;
                    tempHead = tempHead.next;
                }
                last.next = new ListNode(array[i]);
            }
        }
        return head;
    }


    public static void main(String[] args) {
        /*ListNode listNode1 = buildList(new int[]{1, 2, 4});
        ListNode listNode2 = buildList(new int[]{1, 3, 4});
        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);*/

        ListNode listNode1 = buildList(new int[]{5});
        ListNode listNode2 = buildList(new int[]{1, 2, 4});
        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);
    }
}
