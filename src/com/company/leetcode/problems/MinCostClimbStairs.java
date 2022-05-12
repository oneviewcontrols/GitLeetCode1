package com.company.leetcode.problems;

public class MinCostClimbStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        for (int i=2;i<minCost.length;i++) {
            int oneStep = minCost[i - 1] + cost[i - 1];
            int twoStep = minCost[i - 2] + cost[i - 2];
            minCost[i] = Math.min(oneStep,twoStep);
        }
        return minCost[minCost.length - 1];
    }

    public static void runTestCases() {
        MinCostClimbStairs m = new MinCostClimbStairs();
        int[] nums = {10,15,20};
        int[] nums2 = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(m.minCostClimbingStairs(nums));
        System.out.println(m.minCostClimbingStairs(nums2));


    }
}

