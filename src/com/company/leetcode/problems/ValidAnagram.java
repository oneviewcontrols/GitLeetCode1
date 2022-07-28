package com.company.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<String,Integer> map = new HashMap<>();
        String[] str = s.split("");
        for (String x : str) {
            Integer count = map.getOrDefault(x,0);
            count++;
            map.put(x,count);
        }
        String[] tString = t.split("");
        for (String x : tString) {
            if (map.containsKey(x) == false) return false;
            Integer count = map.get(x);
            if (count == 1) {
                map.remove(x);
            } else {
                map.put(x,--count);
            }

        }
        if (map.size() == 0) return true;
        return false;
    }
}
