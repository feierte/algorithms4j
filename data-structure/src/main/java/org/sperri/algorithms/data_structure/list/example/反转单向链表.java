package org.sperri.algorithms.data_structure.list.example;

/**
 * @author Jie Zhao
 * @date 2024/1/7 9:56
 */
public class 反转单向链表 {

    /**
     * 方法一：从旧链表头部获得节点值，用该值生成一个新节点，并插入到新链表的头部
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
//            if (newHead == null) {
//                newHead = new ListNode(head.val);
//            } else {
//                newHead = new ListNode(head.val, newHead);
//            }
            // 上面四行代码可以精简为下面一行
            newHead = new ListNode(head.val, newHead);
            head = head.next;
        }

        return newHead;
    }


    /**
     * 方法二：从旧链表头部移走节点，并插入到新列表中
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode oldHead = head;
            head = head.next;
            oldHead.next = newHead;
            newHead = oldHead;
        }

        return newHead;
    }

    /**
     * 方法三：使用递归方式
     * 单向链表没有 prev 指针，但利用递归的特性找到了最后一个节点的 prev 节点，然后在反转最后一个节点和最后一个节点的 prev 节点
     *
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {
        return reverseListRecursion(head, null);
    }

    private static ListNode reverseListRecursion(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }

        ListNode oldHead = head;
        head = head.next;
        oldHead.next = newHead;
        newHead = oldHead;
        return reverseListRecursion(head, newHead);
    }

    /**
     * 方法三：使用递归方式，精简版
     *
     * @param head
     * @return
     */
    public static ListNode reverseList4(ListNode head) {
        // 递归方式寻找链表中的最后一个节点
        // p == null 表示链表是 null
        // p.next == null 表示找到了链表的最后一个节点
        if (head == null || head.next == null) {
            return head; // 表示找到了最后节点
        }

        ListNode last = reverseList4(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    /**
     * 方法四
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        // 新链表头节点指向旧链表头节点，目的是处理旧链表只有一个节点的情况
        ListNode newHead = head;
        // 旧链表中的第二个节点
        ListNode p = head.next;
        while (p != null) {
            // 将旧链表中的第二个节点从链表中剔除，放到旧链表中的第一个位置
            head.next = p.next;
            p.next = newHead; // 一开始写成了： p.next = head

            // 新链表头节点指向 p
            newHead = p;
            // p 指针继续指向旧链表中的第二个节点，别写成 p = p.next
            p = head.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = newList(5);
        printList(head);
        ListNode listNode = reverseList(head);
        printList(listNode);
        System.out.println("==============================");
        head = newList(2);
        printList(head);
        listNode = reverseList(head);
        printList(listNode);
        System.out.println("==============================");

        head = newList(1);
        printList(head);
        listNode = reverseList(head);
        printList(listNode);
        System.out.println("==============================");

        head = newList(0);
        printList(head);
        listNode = reverseList(head);
        printList(listNode);
        System.out.println("==============================");
    }

    public static ListNode newList(int n) {
        ListNode head = null;
        for (int i = n; i > 0; i--) {
            if (head == null) {
                head = new ListNode(i);
            } else {
                head = new ListNode(i, head);
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%-4d", head.val);
            head = head.next;
        }
        System.out.println();
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
}
