package com.company.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<>();

        for (int i=0;i<nums.length;i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if ((i > 0) && (nums[i] == nums[i - 1])) {
                    low++;
                    continue;
                };
                int total = nums[i] + nums[low] + nums[high];
                if (total < 0) {
                    low++;
                } else if (total > 0) {
                    high--;
                } else {
                    returnList.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while ((low < high) && (nums[low] == nums[low + 1])) {
                        low++;
                    }
                    while ((high > low) && (nums[high] == nums[high - 1])) {
                        high--;
                    }
                    low++;
                    high--;
                }
            }
        }
        return returnList;
    }
    
}
