package com.company.leetcode.assessments;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RandomCompanyOne {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            if (map.containsKey(arr[i])) {
                Integer count = map.get(arr[i]) + 1;
                map.put(arr[i],count);
            } else {
                map.put(arr[i],new Integer(1));
            }
        }
        Map<Integer,Integer> check = new HashMap<>();
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            Integer value = map.get(key);
            if (check.containsKey(value)) return false;
            check.put(value,0);
        }
        return true;
    }

    public static void runTestCases() {
        RandomCompanyOne o = new RandomCompanyOne();
        int[] nums = {1,2,2,1,1,3};
        int[] nums2 = {1,2};
        int[] nums3 = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(o.uniqueOccurrences(nums3));
    }
}
