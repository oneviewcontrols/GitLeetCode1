package com.company.leetcode.problems;

import com.company.leetcode.util.Node;

public class BinarySearchTreeLCA {

    public static Node lca(Node node, int n1, int n2) {

        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.val > n1 && node.val > n2)
            return lca(node.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.val < n1 && node.val < n2)
            return lca(node.right, n1, n2);

        return node;
    }
}
