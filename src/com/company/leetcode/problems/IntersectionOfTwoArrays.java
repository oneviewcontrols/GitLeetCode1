package com.company.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        int[] count = new int[1001];
        // point out the variables present in nums1;
        for (int n : nums1) {
            ++count[n];
        }

        for (int n : nums2) {
            // if nums2 variable is already present in nums1, add it to the ans
            if (count[n] > 0) {
                list.add(n);

                count[n] = -1; // marked the position as it is already in the Answer List
            }
        }

        //convert List into int[];
        int[] ans = new int[list.size()];
        int i = 0;
        for (int n : list) {
            ans[i++] = n;
        }
        return ans;
    }



}
