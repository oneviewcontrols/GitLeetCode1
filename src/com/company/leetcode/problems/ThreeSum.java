package com.company.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        if (nums.length == 0) return returnList;
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            int low = i + 1;
            int high = nums.length - 1;
            if ((i > 0) && (nums[i] == nums[i-1])) continue;
            while (low < high) {
                int total = nums[i] + nums[low] + nums[high];
                if (total < 0) {
                    low++;
                } else if (total > 0) {
                    high--;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i],nums[low],nums[high]);
                    if (returnList.contains(triplet) == false) {
                        returnList.add(triplet);
                    }
                    low++;
                }
            }
        }
        return returnList;
    }
    /*
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            if ((i > 0) && (nums[i] == nums[i -1])) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum > 0) {
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i],nums[low],nums[high]);
                    if (returnList.contains(triplet) == false) {
                        returnList.add(triplet);
                    }
                    while(low<high && nums[low]==nums[low+1]){
                        ++low;
                    }
                    while(low<high && nums[high]==nums[high-1]){
                        --high;
                    }
                    ++low;
                    --high;
                }

            }
        }
        return returnList;
    }
    */
}
