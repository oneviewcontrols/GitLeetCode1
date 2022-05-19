package com.company.leetcode.assessments.roundone;

import com.company.leetcode.util.TreeNode;

public class BloombergThree {

    public int sumOfLeftLeaves(TreeNode root) {
        return getTotal(root,true);
    }

    private int getTotal(TreeNode node,boolean isRight) {
        if (node == null) return 0;
        if ((isRight == false) && (node.left == null) && (node.right == null)) {
            return node.val;
        }
        int total = getTotal(node.left,false);
        int rightTotal = getTotal(node.right,true);
        return total + rightTotal;
    }


    public static void runTestCases() {
        BloombergThree t = new BloombergThree();
        TreeNode node = buildTree();
        System.out.println(t.sumOfLeftLeaves(node));
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }
}
