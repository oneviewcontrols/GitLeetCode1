package com.company.leetcode.problems;

import com.company.leetcode.util.TreeNode;

public class SymmetricTree {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left,TreeNode right) {
            if ((left == null) && (right == null)) return true;
            if ((left != null) && (right == null)) return false;
            if ((left == null) && (right != null)) return false;
            if (left.val == right.val) {
                if (isSymmetric(left.left,right.right) == false) return false;
                if (isSymmetric(left.right,right.left) == false) return false;
            } else {
                return false;
            }
            return true;
        }
    }
}
