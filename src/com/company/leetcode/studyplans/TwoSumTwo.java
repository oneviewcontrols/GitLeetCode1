package com.company.leetcode.studyplans;

public class TwoSumTwo {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = target - nums[right] - nums[left];
            if (sum == 0) {
                return new int[]{++left,++right};
            } else if (sum > 0) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

    public static void runTestCases() {
        TwoSumTwo t = new TwoSumTwo();
        int[] nums = {-1,0};
        int[] result = t.twoSum(nums,-1);
        System.out.println(result[0] + "," + result[1]);
    }
}
