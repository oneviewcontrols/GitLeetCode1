package com.company.leetcode.problems;

import java.util.*;

public class TopK {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],(map.get(nums[i]) + 1));
            } else {
                map.put(nums[i],1);
            }
        }

        Queue<Integer> queue = new PriorityQueue((n1, n2) -> map.get(n1) - map.get(n2));


        Set<Integer> keys = map.keySet();
        for (int n : keys) {
            queue.add(n);
            if (queue.size() > k) queue.poll();
        }

        int[] result = new int[k];
        for (int i = 0;i<k;i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
