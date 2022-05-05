package com.company.leetcode;

import com.company.leetcode.problems.FourSum;
import com.company.leetcode.problems.ThreeSum;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    FourSum s = new FourSum();
        int[] nums1 = {2,2,2,2,2};
        int[] nums2 = {-2,-1,0,0,1,2};
        int[] nums3 = {-2,-1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2};
        int[] nums4 = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> results = s.fourSum(nums4,0);
        Iterator<List<Integer>> it = results.iterator();
        while (it.hasNext()) {
            List<Integer> l = it.next();
            System.out.print("[");
            System.out.print(l + ",");
            System.out.print("]");
        }
    }
}
