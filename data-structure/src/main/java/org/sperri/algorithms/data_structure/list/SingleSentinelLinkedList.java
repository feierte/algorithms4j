package org.sperri.algorithms.data_structure.list;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.sperri.algorithms.common.Printable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 使用头插法实现单链表
 * @author Jie Zhao
 * @date 2023/7/31 21:09
 */
@Slf4j
public class SingleSentinelLinkedList<E> implements List<E>, Printable {

    private int size;
    private Node<E> head;

    public SingleSentinelLinkedList() {
        this.head = new Node<>();
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
        Node node;
        for (node = this.head.next; node != null; node = node.next) {
            if (node.data.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> curNode = head;

            @Override
            public boolean hasNext() {
                Node<E> node = this.curNode.next;
                this.curNode = node;
                return node != null;
            }

            @Override
            public E next() {
                return curNode.data;
            }
        };
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
        Node<E> next = this.head.next;
        Node<E> node = new Node<>(e);
        node.next = next;
        this.head.next = node;
        this.size++;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> node = this.head;
        for (; node.next != null; node = node.next) {
            Node<E> next = node.next;
            if (next.data.equals(o)) {
                if (next.next == null) {
                    // next 结点是最后一个节点，直接删除即可
                    node.next = null;
                } else {
                    // next 结点是中间结点
                    node.next = next.next;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    // todo: 如何高效的实现
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    // todo
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    // todo
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }


    // todo: 如何高效的实现
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    // todo: 如何高效的实现
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
        checkIndex(index);
        Node<E> node = this.head;
        for (int i = 0; i < size; i++) {
            node = node.next;
            if (i == index) {
                return node.data;
            }
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    public void add(int index, E e) {
        checkIndex(index);

        Node<E> node = this.head;
        Node<E> next = node.next;
        Node<E> added = new Node<>(e);
        for (int i = 0; i <= size; i++) {
            // 到了链表最后，插入链表最后即可
            if (next == null) {
                node.next = added;
                size++;
                return; // 算法结束的时候一定记得返回
            }
            if (i == index) {
                node.next = added;
                added.next = next.next;
                size++;
            }
            node = node.next;
            next = next.next;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("illegal index: " + index + ", size: " + this.size);
        }
        Node<E> curNode = this.head;
        Node<E> nextNode = curNode.next;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                curNode.next = nextNode.next;
                size--;
                return nextNode.data;
            } else {
                curNode = curNode.next;
                nextNode = nextNode.next;
            }
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> curNode = this.head;
        int cur = -1;
        for (int i = 0; i < size; i++) {
            curNode = curNode.next;
            if (curNode.data.equals(o)) {
                cur = i;
            }
        }
        return cur;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    // todo
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public void checkIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("illegal index: " + index + ", size: " + this.size);
        }
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("SingleLinkedList [");
        for (Node<E> node = this.head; node != null; node = node.next) {
            if (node.data != null) {
                sb.append(node.data + ", ");
            }
        }
        String substring = sb.substring(0, sb.lastIndexOf(","));
        sb.setLength(0);
        sb.append(substring);
        sb.append("]");
        System.out.println(sb.toString());
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

    public static void main(String[] args) {
        SingleSentinelLinkedList<String> list = new SingleSentinelLinkedList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.print();
        System.out.println(list.contains("hello"));
        System.out.println(list.remove("world"));
        list.print();
        list.add(2, "world");
        list.print();
        list.remove("java");
        list.print();
        System.out.println(list.lastIndexOf("world"));;
    }
}
