package com.company.leetcode.assessments;

public class BloombergFour {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2) {
            return Math.min(cost[0],cost[1]);
        }
        int s1 = cost[0];
        int s2 = cost[1];
        for (int i = 2;i < cost.length;i++) {
            int s3 = cost[i] + Math.min(s1,s2);
            s1 = s2;
            s2 = s3;
        }
        return Math.min(s1,s2);
    }

    public static void runTestCases() {
        BloombergFour f = new BloombergFour();
        int[] nums1 = {10,15,20};
        int[] nums2 = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(f.minCostClimbingStairs(nums1));
        System.out.println(f.minCostClimbingStairs(nums2));
    }

    public int minCostClimbingStairsOld(int[] cost) {
        int[] min = new int[cost.length + 1];

        for (int i=2;i<min.length;i++) {
            int one = min[i - 2] + cost[i - 2];
            int two = min[i - 1] + cost[i - 1];
            System.out.println("One = " + one + " i - 1 = " + (i - 1) + " min[i - 1] = " + min[i - 1] + " cost[i - 1] = " + cost[i - 1]);
            System.out.println("Two = " + two + " i - 2 = " + (i - 2) + " min[i - 2] = " + min[i - 2] + " cost[i - 2] = " + cost[i - 2]);
            System.out.println("---------------------------------------------");
            min[i] = Math.min(one,two);
        }
        return min[min.length - 1];
    }
}
