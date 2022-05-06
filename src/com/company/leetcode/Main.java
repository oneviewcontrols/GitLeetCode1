package com.company.leetcode;

import com.company.leetcode.problems.FourSum;
import com.company.leetcode.problems.NthNodeRemoval;
import com.company.leetcode.problems.ThreeSum;
import com.company.leetcode.problems.TwoSum;
import com.company.leetcode.util.ListNode;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = t.threeSum(nums);
        for (List<Integer> l : result) {
            System.out.println(l);
        }
    }
}

/**
    NthNodeRemoval n = new NthNodeRemoval();
    ListNode node = n.buildTestCase(6);
        node = n.removeNthFromEnd(node,2);
                System.out.print("[");
                while (node != null) {
                System.out.print(node.val + ",");
                node = node.next;
                }
                System.out.println("]");
 **/

/**
TwoSum t = new TwoSum();
    int[] nums = {3,2,4};
    int[] nums2 = {2,7,11,15};
    int[] result = t.twoSum(nums,6);
        for (int i : result) {
                System.out.print(i + ",");
                }
 **/