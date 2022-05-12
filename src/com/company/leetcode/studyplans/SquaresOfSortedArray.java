package com.company.leetcode.studyplans;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    public static void runTestCases() {
        SquaresOfSortedArray s = new SquaresOfSortedArray();
        int[] nums = {-4,-1,0,3,10};
        int[] result = s.sortedSquares(nums);
        System.out.print("[");
        for (int i : result) {
            System.out.print(i + ",");
        }
        System.out.println("]");
    }
}
