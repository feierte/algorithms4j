package org.sperri.algorithms.data_structure.list;

import java.util.*;

/**
 * @author zj
 * @date 2020/7/22 20:17
 */
public class DoubleLinkedList<E> extends AbstractSequentialList<E> {

    private int size;

    private Node<E> first;
    private Node<E> last;

    @Override
    public int size() {
        return size;
    }

    public void addFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (Objects.isNull(f)) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (Objects.isNull(l)) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListItr<>(index);
    }


    public Node<E> node(int index) {
        if (index >= size) {
            return null;
        }

        int cursor = 0;
        Node<E> node = first;
        while (cursor != index) {
            node = node.next;
            cursor++;
        }
        return node;
    }

    private class Iter<E> implements Iterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        Iter() {}

        Iter(int index) {

        }

        @Override
        public boolean hasNext() {
            return next != last;
        }

        @Override
        public E next() {
            return null;
        }
    }

    private class ListItr<E> extends Iter<E> implements ListIterator<E> {

        ListItr(int index) {
            super(index);
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(null != null);

        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        System.out.println(list.node(0).toString());
        System.out.println(list.node(1).toString());
        System.out.println(list.node(3).toString());
    }
}
