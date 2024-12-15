package org.sperri.algorithms.data_structure.tree.binary_tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zj
 * @date 2020/7/12 11:22
 */
public class BinaryTree<T> {

    public static void main(String[] args) {
        // 构造一颗二叉树
        Node<Integer> root = new Node<>(
                new Node<>(new Node<>(4), 2, null),
                1,
                new Node<>(new Node<>(5), 3, new Node<>(6))
        );
        BinaryTree<Integer> tree = new BinaryTree<>(root);

//        List<Integer> nodes = tree.postOrderTraverse();
//        System.out.println(nodes);

//        tree.circleTraverse();
        tree.postOrderTraverse();
    }

    private Node<T> root;
    public Comparator<T> comparator;
    private boolean maxRoot; // true 表示大顶，false 表示小顶

    public BinaryTree(Node<T> root) {
        this(true, root); // 默认大顶排序
    }

    public BinaryTree(boolean maxRoot, Node<T> root) {
        this.maxRoot = maxRoot;
        this.root = root;
    }

    public void add(T e) {
        Node<T> newNode = new Node<>(e);
        if (root == null) {
            root = newNode;
        }

        doAddRecursively(root, newNode);
    }

    private void doAddRecursively(Node<T> root, Node<T> node) {
        if (compare(root, node) >= 0) {
            setChildNode(root.left, node); // todo 如果 left 节点为空，能不能赋值成功？
        } else {
            setChildNode(root.right, node);
        }
    }

    private void setChildNode(Node<T> root, Node<T> node) {
        if (root == null) {
            root = node;
            return;
        }
        doAddRecursively(root, node);
    }

    public int compare(Node<T> a, Node<T> b) {
        return comparator != null ? comparator.compare(a.data, b.data) :
                ((Comparable) a.data).compareTo(b.data);
    }

    /**
     * 遍历一圈
     * @return
     */
    public List<T> circleTraverse() {
        // 当前节点
        Node<T> curr = this.root;
        LinkedList<Node<T>> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.println("去：" + curr.data);
                stack.push(curr);
                curr = curr.left;
            }

            if (curr == null) {
                Node<T> pop = stack.pop();
                System.out.println("回：" + pop.data);
                curr = pop.right;
            }
        }
        return null;
    }

    /**
     * 二叉树前序遍历-迭代实现
     *
     * @return
     */
    public List<T> preOrderTraverse() {
        Node<T> curr = this.root;
        List<T> nodes = new ArrayList<>();
        // 栈，为了记录回来的路
        LinkedList<Node<T>> stack = new LinkedList<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr == null) {
                curr = stack.pop();
            }
            nodes.add(curr.data); // 前序遍历，头节点先遍历
            if (curr.getRight() != null) {
                stack.push(curr.getRight()); // 放进队列尾部，取得时候也要从队列尾部取，这样才是一个栈
            }
            curr = curr.left;
        }
        return nodes;
    }

    /**
     * 二叉树前序遍历-递归实现
     *
     * @return
     */
    public List<T> preOrderTraverseRecursively() {
        Node<T> root = this.root;
        if (root == null) {
            return null;
        }
        List<T> nodes = new ArrayList<>();
        doPreOderTraverseRecursively(root, nodes);
        return nodes;
    }

    /**
     * 递归实现前序遍历
     *
     * @param node
     * @param traverse
     */
    private void doPreOderTraverseRecursively(Node<T> node, List<T> traverse) {
        if (node == null) {
            return;
        }
        traverse.add(node.data);
        doPreOderTraverseRecursively(node.getLeft(), traverse);
        doPreOderTraverseRecursively(node.getRight(), traverse);
    }

    /**
     * 二叉树的中序遍历-迭代实现
     *
     * @return
     */
    public List<T> inOrderTraverse() {
        // curr 表示当前节点
        Node<T> curr = this.root;
        List<T> nodes = new ArrayList<>();
        // 栈，为了记录回来的路
        LinkedList<Node<T>> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr == null) {
                curr = stack.pop(); // 左节点遍历完了，开始遍历右节点
                nodes.add(curr.data);
                // 这里表示左节点和头节点都遍历完了，深度优先遍历右节点
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr = null;
                    continue;
                }
            }

            // 深度优先遍历左节点
            Node<T> left = curr.left;
            if (left != null) {
                stack.push(curr);
                curr = left;
            } else {
                // 左节点为空，遍历头节点
                nodes.add(curr.data);
                curr = null;
            }
        }
        return nodes;
    }

    /**
     * 二叉树的中序遍历-递归实现
     *
     * @return
     */
    public List<T> inOrderTraverseRecursively() {
        Node<T> root = this.root;
        if (root == null) {
            return null;
        }
        List<T> nodes = new ArrayList<>();
        doInOderTraverseRecursively(root, nodes);
        return nodes;
    }

    private void doInOderTraverseRecursively(Node<T> root, List<T> nodes) {
        if (root == null) {
            return;
        }

        doInOderTraverseRecursively(root.left, nodes);
        nodes.add(root.data);
        doInOderTraverseRecursively(root.right, nodes);
    }

    /**
     * 二叉树的后序遍历-迭代实现
     *
     * @return
     */
    public List<T> postOrderTraverse() {
        // curr 表示当前节点
        Node<T> curr = this.root;
        List<T> nodes = new ArrayList<>();
        Node<T> lastVisitedNode = null; // 最近一次从栈中弹出的节点
        // 栈，为了记录回来的路
        LinkedList<Node<T>> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {

            // 深度优先遍历到最左节点
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 找到最左节点后，开始遍历右节点
            curr = stack.pop();

            // 如果右子树为空，或者当前节点是上一个访问节点的右子节点，则访问当前节点
            if (curr.right == null || curr.right == lastVisitedNode) {
                // 当前节点存在右节点，所以再次压入栈
                System.out.println(curr.data);
                lastVisitedNode = curr;
                curr = null;
            } else {
                // 如果存在右子树，将当前节点重新压栈
                stack.push(curr);
                curr = curr.right; // 继续遍历右子树
            }
        }
        return nodes;
    }

    /**
     * 二叉树的后序遍历-递归实现
     *
     * @return
     */
    public List<T> postOrderTraverseRecursively() {
        Node<T> root = this.root;
        if (root == null) {
            return null;
        }
        List<T> nodes = new ArrayList<>();
        doPostOderTraverseRecursively(root, nodes);
        return nodes;
    }

    private void doPostOderTraverseRecursively(Node<T> root, List<T> nodes) {
        if (root == null) {
            return;
        }

        doPostOderTraverseRecursively(root.left, nodes);
        doPostOderTraverseRecursively(root.right, nodes);
        nodes.add(root.data);
    }

//    public static <T> Builder builder(T root) {
//        return new Builder();
//    }
//
//    public static class Builder<T> {
//        public Node<T> currentNode() {
//
//        }
//    }

    @Data
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        public Node(Node<T> left, T data, Node<T> right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }
    }
}
