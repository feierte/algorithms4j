package org.sperri.algorithms.data_structure.list.example;

/**
 * @author Jie Zhao
 * @date 2024/1/7 15:00
 */
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

    static ListNode of(int... data) {
        if (data == null || data.length == 0) {
            return null;
        }

        ListNode head = null;
        for (int i = data.length - 1; i >= 0; i--) {
            head = new ListNode(data[i], head);
        }
        return head;
    }

    public void print() {
        ListNode p = this;
        while (p != null) {
            System.out.printf("%-4d", p.val);
            p = p.next;
        }
        System.out.println();
    }
}
