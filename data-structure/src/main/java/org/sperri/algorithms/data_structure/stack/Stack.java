package org.sperri.algorithms.data_structure.stack;

/**
 * 栈
 *
 * @author Jie Zhao
 * @date 2021/9/7 21:19
 */
public class Stack<E> {

    private Object[] elements;

    private int size;

    public Stack() {

    }


    public Stack(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        elements = new Object[initialCapacity];
    }


    public E pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return null;
    }

    public E peek() {
        return null;
    }

    public void push(E e) {

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
