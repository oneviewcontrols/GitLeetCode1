package com.company.leetcode.assessments.roundone;

public class RandomCompanyFour {
    public boolean divisorGame(int n) {
        boolean result = false;
        if (n == 1) return true;
        int x = n - 1;
        while (x < n) {
            result = !result; // it can only be positive on Alisons turn
            x = n - 1;
            while ((( n % x) != 0) && (x > 0)) x--;
            n = n - x;
        }
        return result;
    }

    public static void runTestCases() {
        RandomCompanyFour r = new RandomCompanyFour();
        System.out.println(r.divisorGame(2));
        System.out.println(r.divisorGame(3));
    }

}
