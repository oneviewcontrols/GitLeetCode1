package com.company.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) return new int[]{0,1};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                int index = map.get(key);
                if (index == i) {
                    continue;
                }
                return new int[]{i,index};
            }
        }
        return new int[]{};
    }

    public static void runTestCase() {
        TwoSum t = new TwoSum();
        int[] nums = {3,2,4};
        int[] nums2 = {2,7,11,15};
        int[] result = t.twoSum(nums,6);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

}
