package com.company.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubNoRepeats {


    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<String,Integer> map = new HashMap<>();
        String[] str = s.split("");
        int startIndex = 0;
        int longest = 0;
        for (int i=0;i<s.length();i++) {
            String letter = str[i];
            if (map.containsKey(letter)) {
                startIndex = Math.max(map.get(letter),startIndex);
            }
            map.put(letter,i + 1);
            longest = Math.max(longest,i - startIndex + 1);
        }
        return longest;
    }


    static public void runTests() {
        LongestSubNoRepeats s = new LongestSubNoRepeats();
        String one = "abcabcbb";
        String two = "bbbb";
        String three = "abbadefg";
        System.out.println(s.lengthOfLongestSubstring(one));
        System.out.println(s.lengthOfLongestSubstring(two));
        System.out.println(s.lengthOfLongestSubstring(three));
    }



















    public int lengthOfLongestSubstringOld(String s) {
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
}
