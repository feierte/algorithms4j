package org.sperri.algorithms.data_structure.queue;

import lombok.Data;
import org.sperri.algorithms.sort.Printable;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * @author Jie Zhao
 * @date 2021/9/7 21:38
 */
public class LinkedQueue<E> extends AbstractQueue<E> implements Printable {

    private int size; // 队列中元素个数
    private int capacity; // 队列容量（最大能存放的元素个数）
    private Node<E> head; // 队头
    private Node<E> tail; // 队尾


    public LinkedQueue() {
        this(Integer.MAX_VALUE);
    }

    public LinkedQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = head;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E next = p.data;
                p = p.next;
                return next;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        if (size == capacity) {
            return false;
        }
        Node<E> node = new Node<>(e, tail, null);
        if (head == null) {
            head = node; // 第一个元素入队时
        } else {
            tail.next = node; // 队列中有元素时，插入结点添加到队列尾部
        }
        tail = node; // 尾结点指向队列尾部
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> node = head;
        E removed = node.data;
        // todo 查看 jdk 队列中删除最后一个元素是如何实现的
        if (head.next == tail) {
            tail = null;
        }
        head = node.next;
        size--;
        return removed;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    @Data
    private static class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void print() {
        Iterator<E> iter = iterator();
        while (iter.hasNext()) {
            System.out.printf("%-4d", iter.next());
        }
        System.out.println();
    }
}
