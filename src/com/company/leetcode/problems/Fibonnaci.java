package com.company.leetcode.problems;

public class Fibonnaci {

    public int fib(int n) {

        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }
}
