package com.company.leetcode.problems;

public class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        boolean nonZero = false;
        int i = 0;
        int j = 0;
        int x = 0;
        while (x < temp.length) {
            int num1 = i < m ? nums1[i] : 1000001;
            int num2 = j < n ? nums2[j] : 1000001;
            temp[x] = num1 <= num2 ? num1 : num2;
            x++;
            if (num1 <= num2) {
                i++;
            } else {
                j++;
            }

        }
        for (int z=0;z<temp.length;z++) {
            nums1[z] = temp[z];
        }
    }

}



