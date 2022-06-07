package com.company.leetcode.problems;

import com.company.leetcode.util.TreeNode;

import java.util.Arrays;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);



        int max = -1;
        int index = -1;
        for (int i=0;i<nums.length;i++) {
            System.out.print(nums[i]);
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        System.out.println();
        TreeNode node = new TreeNode(nums[index]);
        if ((index - 1) >= 0) {
            int[] left = Arrays.copyOfRange(nums,0,index);
            node.left = constructMaximumBinaryTree(left);
        }
        if ((index + 1) < nums.length) {
            int[] right = Arrays.copyOfRange(nums,index + 1,nums.length);
            node.right = constructMaximumBinaryTree(right);
        }
        return node;
    }


}
