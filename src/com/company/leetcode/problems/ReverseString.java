package com.company.leetcode.problems;

public class ReverseString {
    public void reverseString(char[] s) {
        String str = new String(s);
        StringBuilder builder = new StringBuilder(str);
        char[] reversed = builder.reverse().toString().toCharArray();
        for (int i=0;i<reversed.length;i++) {
            s[i] = reversed[i];
        }
    }

    public static void runTestCases() {
        ReverseString r = new ReverseString();
        char[] s = {'h','e','l','l','o'};
        r.reverseString(s);
        System.out.println(s);
    }
}
