package org.sperri.algorithms.data_structure.queue;

/**
 * @author Jie Zhao
 * @date 2021/9/7 21:34
 */
public interface Queue<E> {

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();


    /**
     * 查看队首元素，不出队
     * @return
     */
    E peek();

    /**
     * 队列大小
     * @return
     */
    int size();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 队列是否满了
     * @return
     */
    boolean isFull();
}
