package com.company.leetcode.studyplans;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target > nums[right]) return nums.length;
        int mid = right - left / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) {
            right = mid;
        } else {
            left = mid;
        }
        while (left <= right) {
            int v1 = nums[left];
            int v2 = nums[right]
        }
    }
}
