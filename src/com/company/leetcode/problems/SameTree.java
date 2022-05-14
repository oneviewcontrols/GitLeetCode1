package com.company.leetcode.problems;

import com.company.leetcode.util.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkNode(p,q);
    }

    private boolean checkNode(TreeNode p,TreeNode q) {
        if ((q == null) && (p == null)) return true;
        if ((q != null) && (p == null)) return false;
        if ((q == null) && (p != null)) return false;
        if (q.val == p.val) {
            if (checkNode(q.right,p.right) == false) return false;
            if (checkNode(q.left,p.left) == false) return false;
        } else {
            return false;
        }
        return true;
    }

    public static void runTestCases() {
        SameTree s = new SameTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(s.isSameTree(p, q));
    }
}
