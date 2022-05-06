package com.company.leetcode.problems;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) s.length();
        int[] found = new int[128];
        int start = 0;
        int longest = 0;
        for (int i=0;i<s.length();i++) {
            int intVal = s.charAt(i);
            start = Math.max(start,found[intVal]);
            longest = Math.max(longest,i - start + 1);
            found[intVal] = i + 1;
        }
        return longest;
    }
    public static void runTestCase() {
        LongestSubString l = new LongestSubString();
        String s = "abcabcbb";
        String s2 = "tmmzuxt";
        int result = l.lengthOfLongestSubstring(s2);
        System.out.println("Result = " + result);
    }
}

