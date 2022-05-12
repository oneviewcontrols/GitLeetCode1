package com.company.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class FindCenterStarGraph {

    // if a single number appears in 2 edges it's the center
    public int findCenter(int[][] edges) {
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) return edges[0][0];
        return edges[0][1];
    }

    public static void runTestCases() {
        FindCenterStarGraph f = new FindCenterStarGraph();
        int[][] edges = {{1,2},{2,3},{4,2}};
        int[][] edges2 = {{1,2},{5,1},{1,3},{1,4}};
        System.out.println(f.findCenter(edges));
    }
}
