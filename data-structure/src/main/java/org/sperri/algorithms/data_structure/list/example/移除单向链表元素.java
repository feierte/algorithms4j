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
    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(-1, head);
        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = prev.next;
            }
        }
        return head;
    }

    /**
     * 方法二：递归删除
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements3(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        } 
        return removeElements3(head.next, val);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%-4d", head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(6, null);
        ListNode b = new ListNode(2, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(6, c);
        ListNode e = new ListNode(2, d);
        ListNode f = new ListNode(1, e);

        printList(f);
        printList(removeElements3(f, 6));
    }
}
