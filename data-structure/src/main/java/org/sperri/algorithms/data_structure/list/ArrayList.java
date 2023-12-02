package org.sperri.algorithms.data_structure.list;

import lombok.extern.slf4j.Slf4j;
import org.sperri.algorithms.common.Printable;

import java.util.Arrays;

/**
 * 顺序表示实现的线性表（List）
 *
 * @author Jie Zhao
 * @date 2023/7/29 9:27
 */
@Slf4j
public class ArrayList<E> implements Printable {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private E[] elements;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        if (capacity < 0 || capacity > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        } else if (capacity == 0) {
            this.elements = (E[]) EMPTY_ELEMENTDATA;
        } else {
            this.elements = (E[]) new Object[capacity];
        }
    }

    public void add(E e) {
        if (isFull()) {
            // 扩容
            expansion();
        }
        this.elements[size++] = e;
    }

    // todo: 查看 JDK ArrayList 源码中删除元素是如何实现的
    public boolean remove(E e) {
        if (e == null) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(e)) {
                moveForward(i);
                return true;
            }
        }
        return false;
    }

    // todo: 查看 JDK ArrayList 源码中插入元素是如何实现的
    public void insert(int index, E e) {
        checkIndex(index);

        if (isFull()) {
            expansion();
        }
        moveBackward(index);
        this.elements[index] = e;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("index out of bound. illegal index : " + index);
        }
    }

    private void moveForward(int index) {
        for (int i = index; i < size - 2; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[size - 1] = null;
    }

    private void moveBackward(int index) {
        for (int i = size; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
    }

    // 数组扩容
    private void expansion() {
        int len = this.elements.length;
        E[] newElements = (E[]) new Object[(int) (1.5 * len)];

        // 数组 copy
        System.arraycopy(this.elements, 0, newElements, 0, this.size);
        this.elements = newElements;
    }


    private boolean isFull() {
        if (this.size == this.elements.length) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    @Override
    public void print() {
        log.info("列表中元素：{}", toString());
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList(2);
        list.print();
        list.add("Hello");
        list.add("Hello");
        list.print();
        list.add("Hello");
        list.print();
        list.remove("Hello");
        list.print();
        list.insert(0, "Java");
        list.print();
    }
}
