package com.company.leetcode.problems;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int smallest = height[left] > height[right] ? height[right] : height[left];
            int area = (right - left) * smallest;
            max = max > area ? max : area;
            if (height[left] < height[right]) left++; else right--;
        }
        return max;
    }
}
