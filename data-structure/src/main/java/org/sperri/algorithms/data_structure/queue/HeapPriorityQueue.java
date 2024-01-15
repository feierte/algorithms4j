package org.sperri.algorithms.data_structure.queue;

import org.sperri.algorithms.common.Printable;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * 使用堆实现优先级队列
 *
 * @author jie zhao
 * @date 2024/1/13 9:38
 */
public class HeapPriorityQueue extends AbstractQueue<Priority> implements Printable {


    private Priority[] queue;
    private int capacity;
    private int curr = 1; // 数组索引1开始存储数据，数组的索引0位置不存储数据


    public HeapPriorityQueue() {
        this(Integer.MAX_VALUE);
    }

    public HeapPriorityQueue(int capacity) {
        if (capacity <= 1) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        queue = new Priority[capacity];
    }

    @Override
    public Iterator<Priority> iterator() {
        return new Iterator<Priority>() {

            int p = 1;

            @Override
            public boolean hasNext() {
                return p != curr;
            }

            @Override
            public Priority next() {
                Priority Priority = queue[p];
                p++;
                return Priority;
            }
        };
    }

    @Override
    public int size() {
        return curr - 1;
    }

    @Override
    public boolean offer(Priority e) {
        if (isFull() || e == null) {
            return false;
        }
        queue[curr] = e;
        shiftUp(curr);
        curr++;
        return false;
    }

    private void shiftUp(int index) {
        if (index == 1) {
            return;
        }
        while (index > 1) {
            int parentIndex = index / 2;
            Priority parent = queue[parentIndex];
            Priority child = queue[index];
            if (parent.getPriority() > child.getPriority()) {
                Priority temp = parent;
                queue[parentIndex] = child;
                queue[index] = temp;
            }
            index = parentIndex;
        }
    }

    @Override
    public Priority poll() {
        if (isEmpty()) {
            return null;
        }
        Priority root = queue[1];
        shiftDown(1);
        curr--;
        return root;
    }

    // 错误且丑陋的代码
//    private void shiftDown(int index) {
//        int parent = index;
//        while (index < curr) {
//            int leftIndex = 2 * index;
//            int rightIndex = leftIndex + 1;
//            Priority leftChild = queue[leftIndex];
//            Priority rightChild = queue[rightIndex];
//
//            if (leftChild.getPriority() <= rightChild.getPriority()) {
//                queue[index] = leftChild;
//                parent = index;
//                index = leftIndex;
//            } else {
//                queue[index] = rightChild;
//                parent = index;
//                index = rightIndex;
//            }
//        }
//        queue[parent] = queue[curr--];
//    }

    private void shiftDown(int index) {
        int parent = index;
        int leftIndex = 2 * index;
        int rightIndex = leftIndex + 1;
        int min = parent;

        if (leftIndex < curr && queue[leftIndex].getPriority() < queue[min].getPriority()) {
            min = leftIndex;
        }

        if (rightIndex < curr && queue[rightIndex].getPriority() < queue[min].getPriority()) {
            min = rightIndex;
        }

        if (min != parent) {
            swap(min, parent);
            shiftDown(min);
        }
    }

    private void swap(int i, int j) {
        Priority temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    @Override
    public Priority peek() {
        return queue[1];
    }

    public boolean isFull() {
        return curr == queue.length;
    }

    public boolean isEmpty() {
        return curr == 1;
    }

    @Override
    public void print() {
        Iterator<Priority> iter = iterator();
        while (iter.hasNext()) {
            System.out.printf("%-4d", iter.next().getPriority());
        }
        System.out.println();
    }
}
