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
}
