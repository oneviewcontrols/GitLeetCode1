package com.company.leetcode.problems;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
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
