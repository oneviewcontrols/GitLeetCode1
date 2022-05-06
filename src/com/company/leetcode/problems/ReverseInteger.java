package com.company.leetcode.problems;

public class ReverseInteger {
    public int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int next = x % 10;
            x /= 10;
            if ((reverse > Integer.MAX_VALUE/10) || ((reverse == Integer.MAX_VALUE/10) && (next > 7))) {
                return 0;
            }
            if ((reverse < Integer.MIN_VALUE/10) || ((reverse == Integer.MIN_VALUE/10) && (next < -8))) {
                return 0;
            }
            reverse = reverse * 10 + next;
        }
        return reverse;
    }
}
