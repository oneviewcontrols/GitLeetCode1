package com.company.leetcode.studyplans;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] clone = nums.clone();
        for (int i=0;i<nums.length;i++) {
            int rotatedIndex = (i + k) % nums.length;
            nums[rotatedIndex] = clone[i];
        }
    }

    public static void runTestCases() {
        RotateArray r = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int[] nums2 = {-1,-100,3,99};
        int[] nums3 = {1};
        r.rotate(nums3,2);
        for (int i : nums3) {
            System.out.print(i + ",");
        }
    }
}
