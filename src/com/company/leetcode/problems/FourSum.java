package com.company.leetcode.problems;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4) return returnList;
        for (int i=0;i<nums.length;i++) {
            int low = i + 1;
            int high = nums.length - 1;
            int middle = low + 1;
            while (low < high) {
                while (middle < high) {
                    int total = nums[i] + nums[low] + nums[middle] + nums[high];
                    if (total < target) {
                        middle++;
                    } else if (total > target) {
                        high--;
                    } else {
                        List<Integer> quad = Arrays.asList(nums[i], nums[low],nums[middle],nums[high]);
                        if (returnList.contains(quad) == false) {
                            returnList.add(quad);
                        }
                        while ((middle < high) && (nums[middle] == nums[middle + 1])) middle++;
                        middle++;
                    }
                }
                low++;
                middle = low + 1;
                high = nums.length - 1;
            }
        }
        return returnList;

    }
                    /*System.out.print("Nums i [" + i + "] = " + nums[i] + " ");
                    System.out.print("Nums low [" + low + "] = " + nums[low] + " ");
                    System.out.print("Nums middle [" + middle + "] = " + nums[middle] + " ");
                    System.out.print("Nums high [" + high + "] = " + nums[high] + " ");
                    System.out.println();*/
}
