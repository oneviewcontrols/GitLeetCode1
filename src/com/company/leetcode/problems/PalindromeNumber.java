package com.company.leetcode.problems;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = Integer.toString(x);
        StringBuilder builder = new StringBuilder(s);
        if (builder.reverse().toString().compareTo(s) == 0) {
            return true;
        }
        return false;
    }

    public boolean isPalindromeOld(int x) {
        if (x < 0) return false;
        int original = x;
        int reverse = 0;
        while (x != 0) {
            int next = x % 10;
            x = x/10;
            if ((reverse > Integer.MAX_VALUE) || ((reverse == Integer.MAX_VALUE) && (next > 7))) {
                return false;
            }
            reverse = reverse * 10 + next;
        }
        if (reverse == original) {
            return true;
        }
        return false;
    }
}
