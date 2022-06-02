package com.company.leetcode.problems;

import com.company.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public void breadthFirst(TreeNode root,int target) {
        if (root == null) return;
        if (root.val == target) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            TreeNode node = queue.poll();
            if (node.val == target) return;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }


    }


}
