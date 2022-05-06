package com.company.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    static Map<String,Integer> values = new HashMap<>();
    static {
        values.put("M",1000);
        values.put("D",500);
        values.put("C",100);
        values.put("L",50);
        values.put("X",10);
        values.put("V",5);
        values.put("I",1);
    }


    public int romanToInt(String s) {
        String[] str = s.split("");
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            int cv = values.get(str[i]);
            int nv = 0;
            if ((i + 1) < str.length) {
                nv = values.get(str[i+1]);
            }

            if (cv < nv) {
                sum += nv - cv;
                i = i + 2;
            } else {
                sum += cv;
                i++;
            }
        }
        return sum;

    }
}
