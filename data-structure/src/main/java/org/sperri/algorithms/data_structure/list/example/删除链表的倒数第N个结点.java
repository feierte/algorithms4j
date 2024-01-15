package org.sperri.algorithms.data_structure.list.example;

/**
 * @author jie zhao
 * @date 2024/1/15 20:45
 */
public class 删除链表的倒数第N个结点 {

    /**
     * 方法一：递归 + 哨兵
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(-1, head);
        removeNthFormEndRecursively(sentinel, n);
        return head;
    }

    /*
     * 一直想不出来如何不使用全局变量，在递归方法内部维持一个自增的整数？
     */
    public static int removeNthFormEndRecursively(ListNode node, int n) {
        if (node == null) {
            return 0;
        }

        int count = removeNthFormEndRecursively(node.next, n);
        if (count == n) {
            node.next = node.next.next;
        }
        return count  + 1;
    }

    /**
     * 方法二：快慢指针法
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(-1, head);
        removeNthFormEndRecursively(sentinel, n);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5, 6);
        head.print();
        ListNode node = removeNthFromEnd(head, 6);
        node.print();
    }
}
