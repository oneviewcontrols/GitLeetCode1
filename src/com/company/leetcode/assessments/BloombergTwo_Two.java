package com.company.leetcode.assessments;

import com.company.leetcode.util.TreeNode;

import javax.smartcardio.TerminalFactorySpi;

public class BloombergTwo_Two {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        if ((root.left == null) && (root.right == null)) return 1;
        int count = countSubtrees(root);
        return count;
    }

    private int countSubtrees(TreeNode node) {
        if (node == null) return 0;
        int left = countSubtrees(node.left);
        int right = countSubtrees(node.right);
        int count = left + right;
        if ((node.right != null) && (node.val != node.right.val)) {
            return count;
        }
        if ((node.left != null) && (node.val != node.left.val)) {
            return count;
        }
        return count + 1;
    }

    public static void runTestCases() {
        BloombergTwo_Two b = new BloombergTwo_Two();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        System.out.println(b.countUnivalSubtrees(root));

    }

}
