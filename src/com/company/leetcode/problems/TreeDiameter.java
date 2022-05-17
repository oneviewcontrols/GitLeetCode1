package com.company.leetcode.problems;

public class TreeDiameter {
    public int treeDiameter(int[][] edges) {
        return 0;
    }

    private int[] getDepth(int[][] edges,int i,int[] edge) {
        if (i >= edges.length) return edge;
        int[] edge2 = edges[i];
        if (edge2 == null) return edge;
        if (edge[1] == edge2[0]) {
            return getDepth(edges,i + 1,edge2);
        }
        return edge;
    }
}
