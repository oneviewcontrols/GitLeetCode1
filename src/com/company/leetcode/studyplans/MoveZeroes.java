package com.company.leetcode.studyplans;

import javax.sound.midi.SysexMessage;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }
        for (int i=p;i<nums.length;i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesOld(int[] nums) {
        int i=0;
        int ip = nums.length - 1;
        while (i <= ip) {
            if (nums[i] == 0) {
                for (int j=i;j<=ip;j++) {
                    if ((j + 1) > ip) break;
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
                ip--;
            }
            if (nums[i] != 0) i++;
        }
    }

    public static void runTestCases() {
        MoveZeroes m = new MoveZeroes();
        int[] nums = {0,0,1};
        m.moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
