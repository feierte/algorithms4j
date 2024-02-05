package org.sperri.algorithms.data_structure.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * @author Jie Zhao
 * @date 2024/2/5 10:51
 */
@Slf4j
public class LinkedQueueTest {

    @Test
    @DisplayName("测试offer方法")
    public void testOffer() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        assertIterableEquals(new ArrayList<>(asList()), queue);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertIterableEquals(new ArrayList<>(asList(1, 2, 3)), queue);
    }

    @Test
    @DisplayName("测试poll方法")
    public void testPoll() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.poll();
        assertIterableEquals(new ArrayList<>(asList()), queue);
        queue.print();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.poll();
        assertIterableEquals(new ArrayList<>(asList(2, 3)), queue);
        queue.poll();
        queue.poll();
        assertIterableEquals(new ArrayList<>(asList()), queue);
    }
}
