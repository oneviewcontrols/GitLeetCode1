package com.company.leetcode.problems;

public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int low = 0;
        int high = s.length();
        String longest = "";
        char[] letters = s.toCharArray();
        for (int i=0;i<s.length();i++) {
            low = i;
            high = s.length();
            while (low < high) {
                String sub = s.substring(low,high);
                if (sub.compareTo(new StringBuilder(sub).reverse().toString()) == 0) {
                    longest = sub.length() > longest.length() ? sub : longest;
                    break;
                }
                high--;
            }
        }
        return longest;
    }


    public static void runTests() {
        LongestPalindromicSubString s = new LongestPalindromicSubString();
        String one = "babad";
        String two = "cbbd";
        String three= "axbcdedcbxj";
        System.out.println(s.longestPalindrome(one));
        System.out.println(s.longestPalindrome(two));
        System.out.println(s.longestPalindrome(three));
    }

    public String longestPalindromeOld(String s) {
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
