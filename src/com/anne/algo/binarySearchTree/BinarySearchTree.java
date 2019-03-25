package com.anne.algo.binarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V>  {

    private class Node{
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root;    // root node
    private int count;    // count of nodes

    public BinarySearchTree(){
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public  void insert(K key, V value) {
        root = insert(root, key, value);
    }
    private Node insert(Node node, K key, V value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
         if (node.key.compareTo(key) == 0) {
            node.value = value;
        } else if (node.key.compareTo(key) > 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;

    }

    public V search(K key) {
        return search(root, key);
    }
    private V search(Node node ,K key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return node.value;
        }
        if (key.compareTo(node.key) > 0){
            return search(node.right, key);
        } else {
            return search(node.left, key);
        }
    }

    public boolean contains(K key) {
        return contains(root, key);
    }

    public boolean contains(Node node, K key) {
        if (node == null) {
            return false;
        }
        if (key.equals(node.key)) {
            return true;
        } else if (key.compareTo(node.key) > 0){
            return contains(node.right, key);
        } else {
            return contains(node.left, key);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }

    }

    public void levalOrder() {
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            System.out.println(node.key);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public K maximum() {
        assert count != 0;
        return maximum(root).key;
    }

    private Node maximum(Node root) {
        if (root.right == null) {
            return root.right;
        }
        return maximum(root.right);
    }

    public K minimum() {
        assert count != 0;
        return minimum(root).key;
    }

    private Node minimum(Node root) {
        if (root.left == null) {
            return root.left;
        }
        return maximum(root.left);
    }

    public void removeMax() {
        assert count != 0;
        Node node = root;
        while (node.right != null) {
            if (node.right.right == null){
                node.right = node.right.left;
                break;
            } else {
                node = node.right;
            }
        }
    }

    public void removeMin() {
        assert count != 0;
        removeMin(root);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rigthNode = node.right;
            count --;
            node.right = null;
            return rigthNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void delete(K key) {
        delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else {
            count--;
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node successor = new Node(minimum(node.right));
                successor.right = removeMin(node.right);
                successor.left = node.left;
                return successor;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();
        // 取n个取值范围在[0...m)的随机整数放进二分搜索树中
        int N = 10;
        Integer del = 0;
        for(int i = 0 ; i < N ; i ++){
            Integer key = (int)(Math.random()*100);
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
            System.out.print(key + " ");
            if (i == 5) {
                del = key;
            }
        }
        System.out.println();

        // 测试二分搜索树的size()
        System.out.println("size: " + bst.size());
        System.out.println();

        // 测试二分搜索树的前序遍历 preOrder
        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println();

        // 测试二分搜索树的中序遍历 inOrder
        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println();

        // 测试二分搜索树的后序遍历 postOrder
        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println();

        // 测试二分搜索树的层序遍历 levelOrder
        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println();


        bst.delete(del);
        System.out.println("key: "+ del);

        // 测试二分搜索树的层序遍历 levelOrder
        System.out.println("levelOrder: ");
        bst.levalOrder();
        System.out.println();
    }
}
