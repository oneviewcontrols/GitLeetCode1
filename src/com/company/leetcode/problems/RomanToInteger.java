package com.company.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private Map<String,Integer> values = new HashMap<>();
    {
        values.put("M",1000);
        values.put("CM",900);
        values.put("D",500);
        values.put("CD",400);
        values.put("C",100);
        values.put("XC",90);
        values.put("L",50);
        values.put("XL",40);
        values.put("X",10);
        values.put("IX",9);
        values.put("V",5);
        values.put("IV",4);
        values.put("I",1);

    }

    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        String[] str = s.split("");
        int total = 0;
        for (int i=0;i<s.length();i++) {
            String symbol = str[i];
            String first = str[i];
            String second = (i + 1) < str.length ? str[i+1] : "";
            int secondValue = (i + 1) < str.length ? values.get(second) : 0;
            if (values.get(first) < secondValue) {
                symbol = first + second;
                i++;
            }
            total = total + values.get(symbol);
        }
        return total;
    }



    public static void runTestCases() {
        RomanToInteger r = new RomanToInteger();
        String one = "III";
        String two = "LVIII";
        String three = "MCMXCIV";
        System.out.println(r.romanToInt(one));
        System.out.println(r.romanToInt(two));
        System.out.println(r.romanToInt(three));
    }

















    /**

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
     **/
}
