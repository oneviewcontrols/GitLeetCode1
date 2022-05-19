package com.company.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubNoRepeats {


    public int lengthOfLongestSubstring(String s) {
        String[] str = s.split("");
        Map<String,Integer> map = new HashMap<>();
        int longest = 0;
        int startIndex = 0;
        for (int i=0;i<s.length();i++) {
            if (map.containsKey(str[i])) {
                startIndex = Math.max(map.get(str[i]),startIndex);
            }
            map.put(str[i],i + 1);
            longest = Math.max(map.get(str[i]),i - startIndex + 1);
        }
        return longest;
    }


    public int lengthOfLongestSubstringOld3(String s) {
        String[] str = s.split("");
        Map<String,Integer> map = new HashMap<>();
        int longest = 0;
        int startIndex = 0;
        for (int i=0;i<str.length;i++) {
            if (map.containsKey(str[i])) {
                startIndex = Math.max(map.get(str[i]),startIndex);
            }
            map.put(str[i],i + 1);
            longest = Math.max(longest,i - startIndex + 1);
        }
        return longest;
    }


















    public int lengthOfLongestSubstringOld2(String s) {
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


    static public void runTestCases() {
        LongestSubNoRepeats s = new LongestSubNoRepeats();
      //  String one = "abcabcbb";
        String two = "bbbb";
        String three = "pwwkew";
        //System.out.println(s.lengthOfLongestSubstring(one));
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
