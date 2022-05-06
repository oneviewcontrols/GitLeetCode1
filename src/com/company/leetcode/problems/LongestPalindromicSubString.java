package com.company.leetcode.problems;

public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        if (n == 1) return s;
        String current = "";
        for (int i=0;i<n;i++) {
            String leftCheck = checkAroundCharacter(s,str,current,i,i);
            String rightCheck = checkAroundCharacter(s,str,current,i,i + 1);
            current = leftCheck.length() > rightCheck.length() ? leftCheck : rightCheck;
        }
        return current;
    }

    private String checkAroundCharacter(String s,char[] str,String current,int L,int R) {
        while ((L >= 0) && (R < s.length()) && (str[L] == str[R])){
            current = current.length() > s.substring(L,R + 1).length() ? current : s.substring(L,R + 1);
            L--;
            R++;
        }
        return current;
    }

}
