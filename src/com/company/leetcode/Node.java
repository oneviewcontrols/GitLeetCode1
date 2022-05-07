package com.company.leetcode;

class Node {
    private Node leftChild, rightChild;

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }


    public int height() {
        return checkNode(this);
    }

    private int checkNode(Node node) {
        if (node == null) return 0;
        if (((node.leftChild == null) && (node.rightChild == null))) return 0;
        return 1 + Math.max(checkNode(node.leftChild),checkNode(node.rightChild));
    }

    public static void runTestCase() {
        Node leaf1 = new Node(null, null);
        Node leaf2 = new Node(null, null);
        Node node = new Node(leaf1, null);
        Node root = new Node(node, leaf2);
        System.out.println(root.height());
    }
}