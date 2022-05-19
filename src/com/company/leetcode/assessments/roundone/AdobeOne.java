package com.company.leetcode.assessments.roundone;

import java.util.*;

public class AdobeOne {

    public int[] sortByBits(int[] arr) {
        int[] result = new int[arr.length];
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> sortedMap = new TreeMap<>();
        for (int i=0;i<arr.length;i++) {
            String binary = Integer.toBinaryString(arr[i]);
            binary = binary.replaceAll("0","");
            if (sortedMap.containsKey(binary.length()) == false) {
                List<Integer> nums = new ArrayList<>();
                nums.add(arr[i]);
                sortedMap.put(binary.length(),nums);
            } else {
                List<Integer> nums = sortedMap.get(binary.length());
                nums.add(arr[i]);
                sortedMap.put(binary.length(),nums);
            }
        }
        Collection<Integer> keys  = sortedMap.keySet();
        int counter = 0;
        for (Integer key : keys) {
            List<Integer> nums = sortedMap.get(key);
            Collections.sort(nums);
            for (Integer i : nums) {
                result[counter] = i;
                counter++;
            }
        }
        return result;
    }

    public static void runTestCases() {
        AdobeOne o = new AdobeOne();
        int[] arr =  new int[]{0,1,2,3,4,5,6,7,8};
       int[] result = o.sortByBits(arr);
       for (int i : result) {
           System.out.println(i + ",");
       }
        System.out.println();
    }
}
