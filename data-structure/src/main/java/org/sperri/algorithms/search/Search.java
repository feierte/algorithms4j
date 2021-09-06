package org.sperri.algorithms.search;

/**
 * @author Jie Zhao
 * @date 2021/9/3 20:13
 */
public interface Search<T> {

    /**
     * 查找指定的一个数
     * @param target 待查找的目标值
     * @return 如果存在，返回其索引；否则，返回 -1
     */
    int search(T target);
}
