package org.sperri.algorithms.data_structure.queue;

/**
 * 循环队列
 *
 * @author Jie Zhao
 * @date 2021/9/7 21:29
 */
public class CircularQueue<E> implements Queue<E> {


    private Object[] elements;

    private int head; // 队首
    private int tail; // 队尾


    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * 循环队列的 判空条件为：head == tail
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head == tail;
    }


    /**
     * 循环队列 判满条件为：(tail + 1) % elements.length == head
     * @return
     */
    public boolean isFull() {
        return (tail + 1) % elements.length == head;
    }
}
