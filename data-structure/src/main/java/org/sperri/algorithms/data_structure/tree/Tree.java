package org.sperri.algorithms.data_structure.tree;

/**
 * @author zj
 * @date 2020/7/12 11:13
 */
public interface Tree<K, V> {


    //boolean add(Node<K, V> node);

    /**
     *
     * @param key
     * @return
     */
    V get(K key);


    /**
     * return the numbers of node in this tree. if the tree
     * @return
     */
    int size();


    boolean isEmpty();

    interface Node<K, V> {

        Node<K, V> getPrevNode();

        K getKey();

        V getValue();

        V setValue(V value);
    }

}
