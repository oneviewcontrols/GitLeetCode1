package com.company.leetcode.studyplans;

public class BinaySearch {

    public int search(int[] nums, int target) {

        int index1 = 0;
        int index2 = nums.length - 1;
        if (index1 == index2) return nums[index1] == target ? index1 : -1;
        while (index1 <= index2) {
            if (nums[index1] == target) return index1;
            if (nums[index2] == target) return index2;
            index1++;
            index2--;
        }
        return -1;
    }

    public static void runTestCases() {
        BinaySearch s = new BinaySearch();
        int[] nums = {-1,0,5};
        System.out.println(s.search(nums, 0));
    }

}
