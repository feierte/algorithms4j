package org.sperri.algorithms.data_structure.list;

import lombok.Data;
import org.sperri.algorithms.common.Printable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 使用尾插法实现的单链表
 * @author Jie Zhao
 * @date 2023/8/1 22:22
 */
public class SingleLinkedTailList<E> implements List<E>, Printable {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleLinkedTailList() {
        Node<E> node = new Node<>();
        this.head = node;
        this.tail = node;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        Node<E> node = new Node<>(e);
//        Node<E> curNode = this.head;
//        while (curNode.next != null) {
//            curNode = curNode.next;
//        }
//        curNode.next = node;
//        this.tail = node;
        this.tail.next = node;
        this.tail = node;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> curNode = this.head;
        Node<E> nextNode = this.head.next;
        while (nextNode != null) {
            if (nextNode == this.tail) {
                // 链表的尾结点，直接删除
                curNode.next = null;
                return true;
            }

            if (nextNode.data.equals(o)) {
                // 中间结点删除
                curNode.next = nextNode.next;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.head.next = null;
    }

    @Override
    public E get(int index) {

        int pos = 0;
        Node<E> curNode = this.head.next;
        while (curNode != null) {
            if (pos == index) {
                return curNode.data;
            }
            pos++;
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void print() {

    }

    @Data
    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node() {

        }

        public Node(E data) {
            this.data = data;
        }
    }
}
