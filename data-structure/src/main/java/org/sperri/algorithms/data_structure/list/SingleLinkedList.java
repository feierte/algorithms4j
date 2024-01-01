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
public class SingleLinkedList<E> implements List<E>, Printable {

    private int size;
    private Node<E> head;

    public SingleLinkedList() {
    }

    @Override
    public boolean add(E e) {
        return addFirst(e);
    }

    private boolean addFirst(E e) {
        // Node node = new Node(e, null);
        // node.next = head;
        // head = node;
        // 上面的三行代码可以用下面这一行代码表示
        head = new Node<>(e, head);
        size++;
        return true;
    }

    public void add(int index, E e) {
        checkIndex(index);

        // 1.链表为空时插入，即插入第一个元素
        if (index == 0) {
            addFirst(e);
        }

        // 2.插入到列表中的其他位置
        Node p = this.head;
        for (int i = 0; i <= size; i++, p = p.next) {
            if (i - 1 == index) {
                p.next = new Node<>(e, p.next);
                return;
            }
        }
        size++;
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
        if (head == null) {
            return false;
        }
        for (Node node = this.head.next; node != null; node = node.next) {
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
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
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
