package com.company.leetcode.problems;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {


    public boolean checkInclusion(String s1, String s2) {
        Map<String,Integer> map = new HashMap<>();
        if (s1.length() > s2.length()) return false;
        String[] str1 = s1.split("");
        String[] str2 = s2.split("");
        for (int i=0;i<str1.length;i++) {
            if (map.containsKey(str1[i])) {
                int count = map.get(str1[1]) + 1;
                map.put(str1[i],count);
            } else {
                map.put(str1[i],1);
            }
        }
        for (int i=0;i<str2.length;i++) {
            if (map.containsKey(str2[i])) {
                int count = map.get(str2[i]);
                --count;
                map.put(str2[i], count);
            }
        }
        Collection<Integer> values = map.values();
        for (Integer x : values) {
            if (x != 0) return false;
        }
        return true;
    }

}
