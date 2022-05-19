package com.company.leetcode.problems;

import java.math.BigInteger;

public class NumStepsBinaryString {

    public int numSteps(String s) {
        if (s.length() == 1) return 0;
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1;i > 0;i--) {
            char c = chars[i];
            if (c == '0') {
                count++;
                i--;
            } else {
                count++;
                while ((i > 0) && (chars[i]) == '1') {
                    count++;
                    i--;
                }
                if (i==0) count++;
                chars[i] = '1';
            }
        }
        return count;
    }

    public int numStepsOld(String s) {
        // if the size of binary is 1
        // then the number of actions will be zero
        if (s.length() == 1)
            return 0;

        // initializing the number of actions as 0 at first
        int count_ = 0;
        char[] s1=s.toCharArray();
        for (int i = s.length() - 1; i > 0;i--) {
            // start traversing from the last digit
            // if its 0 increment the count and decrement i
            if (s1[i] == '0') {
                count_++;
                i--;
            }
            // if s[i] == '1'
            else {
                count_++;

                // stop until you get 0 in the binary
                while (s1[i] == '1' && i > 0) {
                    count_++;
                    i--;
                }
                if (i == 0)
                    count_++;

                // when encounter a 0 replace it with 1
                s1[i] = '1';
            }
        }
        return count_;
    }



    public static void runTestCases() {
        NumStepsBinaryString b = new NumStepsBinaryString();
        String s = "1111110011101010110011100100101110010100101110111010111110110010";
        System.out.println(b.numSteps(s));
    }
}
