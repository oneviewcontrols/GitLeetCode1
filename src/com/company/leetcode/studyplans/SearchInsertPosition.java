package com.company.leetcode.studyplans;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] < target) return nums.length;
        if (nums[0] > target) return 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            left = nums[middle] > target ? left : middle;
            right = nums[middle] > target ? middle : right;
            if ((left + 1) == right) return right;
        }
        return left;
    }
}
