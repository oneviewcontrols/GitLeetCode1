package com.company.leetcode.problems;

public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String prefix = strs[0];
        for (int i=0;i<strs.length;i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length() - 1);
                if (prefix.length() == 0) return "";
            }
        }
        return prefix;

    }








    public String longestCommonPrefixOld(String[] strs) {
        if (strs.length == 0 ) return "";
        if (strs.length == 1) return strs[0];
        String prefix = strs[0];
        for (int i=0;i<strs.length;i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length() - 1);
                if (prefix.length() == 0) return "";
            }
        }
        String s = new String();
        s.substring(5).equals()
        return prefix;
    }
}
