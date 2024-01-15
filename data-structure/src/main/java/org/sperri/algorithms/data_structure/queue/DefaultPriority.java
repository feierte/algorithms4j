package org.sperri.algorithms.data_structure.queue;

/**
 * @author jie zhao
 * @date 2024/1/13 10:12
 */
public class DefaultPriority implements Priority {

    private int priority;

    public DefaultPriority(int priority) {
        this.priority = priority;
    }
    @Override
    public int getPriority() {
        return priority;
    }
}
