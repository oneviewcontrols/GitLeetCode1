package com.company.leetcode.problems;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {


    public double findMedianSortedArraysOld(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        if (mergedArray.length == 0) return 0;
        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);
        Arrays.sort(mergedArray);
        if ((mergedArray.length % 2) == 0) {
            int point1 = (mergedArray.length / 2) - 1;
            int point2 = mergedArray.length / 2;
            return (double) (mergedArray[point1] + mergedArray[point2]) / 2;
        } else {
            return mergedArray[mergedArray.length / 2];
        }
    }
}
