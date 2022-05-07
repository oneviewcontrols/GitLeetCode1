package com.company.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 1) return false;
        if ((s.length() % 2) != 0) return false;
        String[] str = s.split("");
        Map<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("[","]");
        map.put("{","}");
        for (int i=0;i<s.length();i++) {
             isValidSubString(i, s, str, map);
        }
        return false;
    }

    private boolean isValidSubString(int start,String s,String[] str,Map<String,String> map) {
        if (s.length() == 0) return true;
        String left = str[start];
        if (map.containsKey(left) == false) return false;
        int rightIndex = s.indexOf(map.get(left));
        if (rightIndex == -1) return false;
        rightIndex--;
        if (rightIndex == start) return true;
        String subString = s.substring(start + 1,rightIndex);
        return isValidSubString(start,s,str,map);
    }

    public static void runTestCase() {
        ValidParentheses v = new ValidParentheses();
        String s1 = "()[]{}";
        String s2 = "(";
        String s3 = "()]{}";
        String s4 = "()[]{";
        String s5 = ")[]{";
        System.out.println("()[]{} = " + v.isValid(s1));
        System.out.println("( = " + v.isValid(s2));
        System.out.println("()]{} = " + v.isValid(s3));
        System.out.println("()[]{ = " + v.isValid(s4));
        System.out.println(")[]{} = " + v.isValid(s5));
    }
}

