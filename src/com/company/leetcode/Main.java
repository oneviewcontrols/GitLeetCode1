package com.company.leetcode;

import com.company.leetcode.problems.ThreeSum;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    ThreeSum s = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> results = s.threeSum(nums);
        Iterator<List<Integer>> it = results.iterator();
        while (it.hasNext()) {
            List<Integer> l = it.next();
            System.out.print("[");
            System.out.print(l + ",");
            System.out.print("]");
        }
    }
}
