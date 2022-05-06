package com.company.leetcode.problems;

public class AsciiToInteger {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        s = s.trim();
        boolean hitNonNumeric = false;
        char[] chars = s.toCharArray();
        StringBuffer buff = new StringBuffer();
        if (((chars[0] != '-') && (chars[0] != '+')) && (!Character.isDigit(chars[0]))) return 0;
        for (int i=0;i<s.length();i++) {
            if (((i + 1) < s.length()) && (((chars[i] == '-') || (chars[i] == '+'))) && (Character.isDigit(chars[i + 1]) == true)) {
                if (i > 0) buff = new StringBuffer();
                buff.append(chars[i]);
            } else if (Character.isDigit(chars[i])) {
                if (hitNonNumeric == true) return 0;
                buff.append(chars[i]);
            } else {
                hitNonNumeric = true;
            }
        }
        if (buff.length() == 0) return 0;
        System.out.println(("Buff = " + buff.toString()));
        long result = Long.parseLong(buff.toString());
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return Math.toIntExact(result);
    }
}
