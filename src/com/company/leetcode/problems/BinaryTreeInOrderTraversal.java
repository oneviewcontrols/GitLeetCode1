package com.company.leetcode.problems;

import com.company.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        return traverse(root,new ArrayList<Integer>());
    }

    public List<Integer> traverse(TreeNode node, List<Integer> list) {
        if (node == null) return list;

        list = traverse(node.left,list);
        list.add(new Integer(node.val));
        list = traverse(node.right,list);
        return list;
    }
}
