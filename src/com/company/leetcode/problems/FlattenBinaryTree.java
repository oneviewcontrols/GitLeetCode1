package com.company.leetcode.problems;

import com.company.leetcode.util.TreeNode;

import java.util.*;

public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue = traverse(root,queue);
        root = queue.poll();
        root.right = null;
        root.left = null;
        while (queue.isEmpty() == false) {
            TreeNode node = queue.poll();
            root.right = node;
            root.left = null;
            root = root.right;
        }
    }

    public Queue<TreeNode> traverse(TreeNode node,Queue<TreeNode> queue) {
        if (node == null) return queue;
        queue.add(node);
        queue = traverse(node.left,queue);
        queue = traverse(node.right,queue);
        return queue;
    }

}
